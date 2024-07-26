import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements in the linked list
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        // Input the elements of the linked list
        System.out.println("Enter the elements of the linked list:");
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        // Swap every two adjacent nodes
        head = swapPairs(head);

        // Output the swapped linked list
        System.out.println("Linked list after swapping pairs:");
        printList(head);

        scanner.close();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node to act as the previous node to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list and swap pairs
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to the next pair
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
