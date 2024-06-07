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
class Solution {
          private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traversalBinary(root);
        return list;
    }

    private void traversalBinary(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversalBinary(root.left);
        traversalBinary(root.right);
    }
}