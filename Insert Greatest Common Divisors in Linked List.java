// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    // Helper function to calculate the GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Pointer to traverse the linked list
        ListNode current = head;

        while (current != null && current.next != null) {
            // Find the GCD between current node and the next node
            int gcdValue = gcd(current.val, current.next.val);

            // Create a new node with the GCD value
            ListNode gcdNode = new ListNode(gcdValue);

            // Insert the GCD node between current node and next node
            gcdNode.next = current.next;
            current.next = gcdNode;

            // Move to the next pair (current now points to gcdNode)
            current = gcdNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: [18,6,10,3]
        ListNode head1 = new ListNode(18);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(10);
        head1.next.next.next = new ListNode(3);
        ListNode result1 = solution.insertGreatestCommonDivisors(head1);
        printList(result1); // Expected output: 18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3

        // Example 2: [7]
        ListNode head2 = new ListNode(7);
        ListNode result2 = solution.insertGreatestCommonDivisors(head2);
        printList(result2); // Expected output: 7
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
