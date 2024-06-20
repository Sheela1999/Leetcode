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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = computeHeight(root);
        if (height == 0) {
            return 1;
        }

        int upperCount = (1 << height) - 1;
        int left = 0, right = upperCount;

        while (left < right) {
            int idxToCheck = (right - left + 1) / 2 + left;
            if (nodeExists(idxToCheck, height, root)) {
                left = idxToCheck;
            } else {
                right = idxToCheck - 1;
            }
        }
        return upperCount + left + 1;
    }

    private static int computeHeight(TreeNode node) {
        int height = 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static boolean nodeExists(int idx, int height, TreeNode node) {
        int left = 0, right = (1 << height) - 1;
        for (int i = 0; i < height; i++) {
            int mid = (left + right) / 2;
            if (idx <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n == 0){
            System.out.println(0);
            return;
        }

        TreeNode root = new TreeNode(scan.nextInt());
        TreeNode[] nodes = new TreeNode[n];
        nodes[0] = root;

        for(int i = 1; i < n; i++){
            int value = scan.nextInt();
            nodes[i] = new TreeNode(value);

            if (i % 2 == 1) {
                nodes[(i - 1) / 2].left = nodes[i];
            } else {
                nodes[(i - 1) / 2].right = nodes[i];
            }
        }
         
        Solution sol = new Solution();
        int result = sol.countNodes(root);
        System.out.println(result);

        scan.close();
    }
}