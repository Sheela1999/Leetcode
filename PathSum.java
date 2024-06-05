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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return leaf(root, targetSum);   
    }

    private boolean leaf(TreeNode root, int s){
        if(root == null){
            return false;
        }
        s -= root.val;
        if(root.left == null && root.right == null && s == 0){
            return true;
        }
        return leaf(root.left, s) || leaf(root.right, s);
    }
}