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
      private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return sArray(0, nums.length - 1);     
    }

    private TreeNode sArray(int l, int r){
        if(l > r){
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode left = sArray(l, mid - 1);
        TreeNode right = sArray(mid + 1, r);
        return new TreeNode(nums[mid], left, right);
    }
}