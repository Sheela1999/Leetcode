class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }

        // Check if there's a matching path starting from the current root
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // Helper function to check if linked list matches the path starting at the given tree node
    private boolean dfs(ListNode head, TreeNode node) {
        if (head == null) {
            return true; // Reached the end of the linked list
        }
        if (node == null) {
            return false; // Reached the end of the tree branch, but the linked list hasn't ended
        }
        if (head.val != node.val) {
            return false; // Values don't match
        }

        // Continue to the next node in the linked list and down the tree
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }
