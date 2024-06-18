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

public class ReverseLinkedList {
    
    // Function to reverse the linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize previous node to null
        ListNode current = head; // Start with the head as the current node
        
        // Traverse the list
        while (current != null) {
            ListNode nextTemp = current.next; // Save the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move the prev pointer to current
            current = nextTemp; // Move to the next node
        }
        
        return prev; // New head of the reversed list
    }
    
    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Reversed list: []");
            return;
        }

        System.out.println("Enter the elements of the linked list:");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;
        
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        System.out.println("Original list:");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed list:");
        printList(reversedHead);

        scanner.close();
    }
}