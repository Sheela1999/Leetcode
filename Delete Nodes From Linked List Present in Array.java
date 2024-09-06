import java.util.HashSet;

class Solution {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode removeElements(ListNode head, int[] nums) {
        // Create a set of nums to check if a node value exists in nums
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node that helps in handling edge cases such as removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Traverse the list and remove elements that exist in nums
        ListNode current = dummy;
        while (current.next != null) {
            if (set.contains(current.next.val)) {
                // Remove the node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        
        return dummy.next; // Return the new head of the list
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 3};
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode result1 = solution.removeElements(head1, nums1);
        printList(result1);  // Expected Output: 4 -> 5
        
        // Test case 2
        int[] nums2 = {1};
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(1);
        head2.next.next.next.next.next = new ListNode(2);
        ListNode result2 = solution.removeElements(head2, nums2);
        printList(result2);  // Expected Output: 2 -> 2 -> 2

        // Test case 3
        int[] nums3 = {5};
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        ListNode result3 = solution.removeElements(head3, nums3);
        printList(result3);  // Expected Output: 1 -> 2 -> 3 -> 4
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
