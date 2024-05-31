import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

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
            System.out.println("The list is empty.");
            return;
        }
        
        System.out.println("Enter the elements of the linked list:");
        ListNode ln = new ListNode(scanner.nextInt());
        ListNode current = ln;
        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }
        
        System.out.println("Original List:");
        printList(ln);

        ln = deleteDuplicates(ln);

        System.out.println("List after removing duplicates:");
        printList(ln);
    }
}