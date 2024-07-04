public class LinkedListMerge {
    
    // Method to merge nodes between zeros
    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy node to help with edge cases
        ListNode current = dummy; // Pointer to construct the new list
        ListNode temp = head.next; // Start after the initial 0

        while (temp != null) {
            int sum = 0; // To store the sum of values between zeros

            // Sum up all values until we reach the next zero
            while (temp != null && temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }

            // Move past the zero
            if (temp != null) {
                temp = temp.next;
            }

            // Create a new node with the sum and add it to the new list
            current.next = new ListNode(sum);
            current = current.next;
        }

        return dummy.next; // Return the new list, skipping the dummy node
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input length of the list
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        // Input the list elements
        System.out.println("Enter the elements of the list separated by spaces:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        // Perform the merge operation
        ListNode result = mergeNodes(dummy.next);

        // Print the result
        System.out.print("Merged List: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}