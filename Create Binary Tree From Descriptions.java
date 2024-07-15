import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeConstructor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of descriptions
        int n = scanner.nextInt();
        int[][] descriptions = new int[n][3];
        
        // Read each description
        for (int i = 0; i < n; i++) {
            descriptions[i][0] = scanner.nextInt(); // parent
            descriptions[i][1] = scanner.nextInt(); // child
            descriptions[i][2] = scanner.nextInt(); // isLeft
        }
        
        // Call the function to construct the binary tree
        TreeNode root = createBinaryTree(descriptions);
        
        // Print the tree in level order to verify the output
        List<Integer> levelOrder = levelOrderTraversal(root);
        System.out.println(levelOrder);
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        // Iterate through each description to build the node map and identify children
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            // Get or create the parent node
            TreeNode parent = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parent);
            
            // Get or create the child node
            TreeNode child = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, child);
            
            // Set the child to the appropriate side of the parent
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            // Track the child node
            children.add(childVal);
        }

        // The root node is the one that is not a child of any node
        TreeNode root = null;
        for (int val : nodeMap.keySet()) {
            if (!children.contains(val)) {
                root = nodeMap.get(val);
                break;
            }
        }
        
        return root;
    }

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
