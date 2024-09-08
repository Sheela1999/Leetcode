/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
		int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Determine the size of each part and how many larger parts we need
        int partSize = length / k;  // Minimum size of each part
        int extraNodes = length % k; // Number of parts that need an extra node

        // Initialize the result array
        ListNode[] result = new ListNode[k];

        // Reset current to head
        current = head;

        // Iterate over each part
        for (int i = 0; i < k; i++) {
            // Assign current node to result[i]
            result[i] = current;

            // Determine the size of this part
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0);

            // Move current pointer to the end of this part
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }

            // Disconnect the current part from the rest of the list
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }

        return result;
	}
}