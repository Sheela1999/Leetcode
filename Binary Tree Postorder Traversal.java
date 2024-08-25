import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        binaryTree(root);
        return list;
    }

    private void binaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTree(root.left);
        binaryTree(root.right);
        list.add(root.val);
    }

    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
        if (i < arr.length && arr[i] != -1) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the binary tree:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the values of the nodes in level-order (use -1 for null):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        TreeNode root = insertLevelOrder(arr, null, 0);

        Solution solution = new Solution();
        List<Integer> result = solution.postorderTraversal(root);

        System.out.println("Postorder traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
