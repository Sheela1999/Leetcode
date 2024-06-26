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

public class BalancedBST {

    // Method to perform in-order traversal and store the node values in a list
    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inorderTraversal(root.left, nodes);
            nodes.add(root.val);
            inorderTraversal(root.right, nodes);
        }
    }

    // Method to build a balanced BST from a sorted list of node values
    private TreeNode buildBalancedBST(List<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBalancedBST(nodes, start, mid - 1);
        node.right = buildBalancedBST(nodes, mid + 1, end);
        return node;
    }

    // Method to balance the given BST
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);  // Step 1: Get sorted node values
        return buildBalancedBST(nodes, 0, nodes.size() - 1);  // Step 2: Build balanced BST
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
    public void inorderTraversalPrint(TreeNode root) {
        if (root != null) {
            inorderTraversalPrint(root.left);
            System.out.print(root.val + " ");
            inorderTraversalPrint(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BalancedBST bst = new BalancedBST();
        TreeNode root = null;

        System.out.println("Enter the number of nodes:");
        int n = scanner.nextInt();

        System.out.println("Enter the node values:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            root = bst.insert(root, value);
        }

        System.out.println("Original BST (In-order Traversal):");
        bst.inorderTraversalPrint(root);
        System.out.println();

        // Balance the BST
        TreeNode balancedRoot = bst.balanceBST(root);

        System.out.println("Balanced BST (In-order Traversal):");
        bst.inorderTraversalPrint(balancedRoot);
        System.out.println();

        scanner.close();
    }
}