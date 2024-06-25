/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BSTToGreaterTree {
    
    // Variable to store the cumulative sum during the traversal
    private int sum = 0;

    // Method to convert BST to Greater Tree
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            // Traverse the right subtree first (reverse of in-order traversal)
            convertBST(root.right);
            
            // Update the sum and the node's value
            sum += root.val;
            root.val = sum;
            
            // Traverse the left subtree
            convertBST(root.left);
        }
        return root;
    }

    // Helper method to insert a node in the BST
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.val) {
            root.left = insert(root.left, key);
        } else if (key > root.val) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // Method to perform in-order traversal and print the tree
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTToGreaterTree bst = new BSTToGreaterTree();
        TreeNode root = null;

        System.out.println("Enter the number of nodes:");
        int n = scanner.nextInt();

        System.out.println("Enter the node values:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            root = bst.insert(root, value);
        }

        System.out.println("Original BST (In-order Traversal):");
        bst.inorderTraversal(root);
        System.out.println();

        // Convert the BST to Greater Tree
        bst.convertBST(root);

        System.out.println("Greater Tree (In-order Traversal):");
        bst.inorderTraversal(root);
        System.out.println();

        scanner.close();
    }
}