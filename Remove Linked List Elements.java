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

public class RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Iterate through the list
        while (current.next != null) {
            // If the next node's value is the target value, skip it
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        // Return the new head (skip the dummy node)
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the list:");
        int n = scanner.nextInt();

        ListNode head = null, tail = null;
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Enter the value to remove:");
        int val = scanner.nextInt();

        head = removeElements(head, val);
        System.out.println("List after removing elements:");
        printList(head);
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}