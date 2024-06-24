public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the linked list
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        // Create the head of the linked list
        ListNode head = null, tail = null;

        // Read the elements and create the linked list
        System.out.println("Enter the elements of the linked list: ");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        // Read the value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Reverse the nodes in k group and get the new head
        ListNode newHead = reverseKGroup(head, k);

        // Print the modified linked list
        System.out.print("Modified linked list: ");
        printList(newHead);
    }

    // Function to reverse nodes of a linked list in groups of k
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to handle the new head of the modified list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode curr = dummy, nex = dummy, pre = dummy;
        int count = 0;

        // Count the number of nodes in the linked list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Loop until we have groups to reverse
        while (count >= k) {
            curr = pre.next; // Current node to reverse
            nex = curr.next; // Next node to reverse
            // Reverse the group
            for (int i = 1; i < k; i++) {
                curr.next = nex.next; // Adjust the current node's next pointer
                nex.next = pre.next; // Adjust the next node's next pointer
                pre.next = nex; // Adjust the previous node's next pointer
                nex = curr.next; // Move to the next node
            }
            pre = curr; // Move the pre pointer to the end of the reversed group
            count -= k; // Decrease the count by k
        }
        return dummy.next; // Return the new head of the list
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

Explanation:
ListNode Class:

The ListNode class defines the structure of each node in the linked list with an integer value (val) and a reference to the next node (next).
Main Method:

The main method reads the number of elements in the linked list and the elements themselves from the user.
It constructs the linked list by creating nodes and linking them.
It reads the value of k from the user.
It calls the reverseKGroup method to reverse the nodes in groups of k.
It prints the modified linked list using the printList method.
reverseKGroup Method:

This method reverses the nodes of the linked list in groups of k.
A dummy node is used to handle edge cases and simplify the reversal process.
Three pointers (curr, nex, pre) are used to manage the reversal:
curr points to the current node being processed.
nex points to the next node to be reversed.
pre points to the node before the current group.
The total number of nodes in the list is counted first.
The outer while loop processes the list in groups of k until fewer than k nodes remain.
The inner for loop reverses k nodes by adjusting the next pointers.
After reversing each group, the pre pointer is updated to the end of the reversed group.
The modified head of the list is returned.
printList Method:

This helper method prints the elements of the linked list starting from the given head.
Example:
For the input linked list [1,2,3,4,5] with k = 2:

The main method reads the input, constructs the linked list, and calls reverseKGroup.
reverseKGroup processes the list in groups of 2:
First group: [1,2] is reversed to [2,1].
Second group: [3,4] is reversed to [4,3].
Remaining node [5] remains as it is.
The modified list is [2,1,4,3,5].
The printList method prints the result: 2 1 4 3 5.
For the input linked list [1,2,3,4,5] with k = 3:

The main method reads the input, constructs the linked list, and calls reverseKGroup.
reverseKGroup processes the list in groups of 3:
First group: [1,2,3] is reversed to [3,2,1].
Remaining nodes [4,5] remain as they are.
The modified list is [3,2,1,4,5].
The printList method prints the result: 3 2 1 4 5.