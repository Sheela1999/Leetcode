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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to start the merged list
        ListNode ln = new ListNode(-1);
        ListNode current = ln;

        // Iterate through both lists
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
		
		// Attach the remaining part of list1 or list2
        if(list1 != null){
            current.next = list1;
        }else{
            current.next = list2;
        }
		// The merged list starts from the next of dummy node

        return ln.next;  
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        // Read and create list1
        String[] values1 = scan.nextLine().split(" ");
        ListNode list1 = createLinkedList(values1);
        
		// Read and create list2
        String[] values2 = scan.nextLine().split(" ");
        ListNode list2 = createLinkedList(values2);
        
		// Merge the lists
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        
		// Print the merged list
        System.out.println("Merged list:");
        printList(mergedList);
    }

    // Utility method to create a linked list from an array of values
    private static ListNode createLinkedList(String[] values) {
        if (values.length == 0 || values[0].isEmpty()) {
            return null;
        }
        
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }
        return head;
    }

    // Utility method to print a linked list
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
