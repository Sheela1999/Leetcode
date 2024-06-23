public class Solution {
	
	public static ListNode mergeKLists(ListNode[] lists) {
        // Edge case: if the input lists array is empty
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        // Base case: if there's only one list, return it
        if (start == end) {
            return lists[start];
        }

        // Find the middle of the current range
        int mid = start + (end - start) / 2;

        // Recursively merge the left and right halves
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);

        // Merge the two sorted halves
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Dummy node to simplify the merged list construction
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Merge the two lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        // Utility function to print a linked list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
	
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);

        // Read the number of lists
        System.out.print("Enter the number of linked lists: ");
        int k = scanner.nextInt();

        // Initialize the array of ListNode
        ListNode[] lists = new ListNode[k];

        // Read each linked list
        for (int i = 0; i < k; i++) {
            System.out.print("Enter the number of elements in list " + (i + 1) + ": ");
            int n = scanner.nextInt();
            if (n == 0) {
                lists[i] = null;
                continue;
            }
            System.out.print("Enter the elements of list " + (i + 1) + ": ");
            ListNode head = new ListNode(scanner.nextInt());
            ListNode current = head;
            for (int j = 1; j < n; j++) {
                current.next = new ListNode(scanner.nextInt());
                current = current.next;
            }
            lists[i] = head;
        }

        // Merge the k sorted linked lists
		Solution sol = new Solution();
        ListNode mergedHead = sol.mergeKLists(lists);

        // Print the merged linked list
        System.out.print("Merged sorted linked list: ");
        printList(mergedHead);

        // Close the scanner
        scanner.close();
    }
}