import java.util.*;

// Definition for an N-ary tree node
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

public class Solution {
    
    // Recursive approach
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorderHelper(child, result);
        }
        result.add(root.val);
    }

    public static void main(String[] args) {
        // Example 1: root = [1,null,3,2,4,null,5,6]
        Node root = new Node(1, Arrays.asList(
            new Node(3, Arrays.asList(
                new Node(5),
                new Node(6)
            )),
            new Node(2),
            new Node(4)
        ));

        Solution solution = new Solution();
        List<Integer> result = solution.postorder(root);

        System.out.println(result); // Output: [5, 6, 3, 2, 4, 1]
    }
}
