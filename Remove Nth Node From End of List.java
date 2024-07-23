import java.util.Scanner;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of elements in the linked list
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        
        // Initialize the head of the linked list
        ListNode head = null, tail = null;
        
        // Read the elements of the linked list
        System.out.println("Enter the elements of the linked list:");
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
        
        // Read the value of 'k' (the nth node from the end)
        System.out.print("Enter the value of n (the nth node from the end to remove): ");
        int k = scanner.nextInt();
        
        // Close the scanner
        scanner.close();
        
        // Remove the nth node from the end
        head = removeNthFromEnd(head, k);
        
        // Print the modified linked list
        System.out.println("Modified linked list:");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    
    // Method to remove the nth node from the end of the list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers, both starting at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move the first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from the end
        second.next = second.next.next;
        
        // Return the head of the modified list
        return dummy.next;
    }
}
