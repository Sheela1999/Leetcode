public class AddTwoNumbers {
    
    // Function to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head to simplify code
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0; // Initialize carry to 0

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0; // Get value from l1, if null use 0
            int y = (q != null) ? q.val : 0; // Get value from l2, if null use 0
            int sum = carry + x + y; // Sum current digits and carry
            carry = sum / 10; // Update carry
            curr.next = new ListNode(sum % 10); // Create new node with the digit
            curr = curr.next; // Move to the next node
            if (p != null) p = p.next; // Move to the next node in l1
            if (q != null) q = q.next; // Move to the next node in l2
        }
        
        if (carry > 0) { // If carry is left, create a new node with the carry
            curr.next = new ListNode(carry);
        }
        
        return dummyHead.next; // Return the head of the new list
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

    // Function to create a linked list from an array of integers
    public static ListNode createList(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the first linked list:");
        int n1 = scanner.nextInt();
        int[] l1Array = new int[n1];
        System.out.println("Enter the elements of the first linked list:");
        for (int i = 0; i < n1; i++) {
            l1Array[i] = scanner.nextInt();
        }
        ListNode l1 = createList(l1Array);

        System.out.println("Enter the number of elements in the second linked list:");
        int n2 = scanner.nextInt();
        int[] l2Array = new int[n2];
        System.out.println("Enter the elements of the second linked list:");
        for (int i = 0; i < n2; i++) {
            l2Array[i] = scanner.nextInt();
        }
        ListNode l2 = createList(l2Array);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Resultant linked list after addition:");
        printList(result);

        scanner.close();
    }
}