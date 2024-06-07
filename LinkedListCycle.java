/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }  
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }  
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n == 0){
            System.out.println("false");
            return;
        }

        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }
        int pos = scanner.nextInt();

        if (pos != -1) {
            ListNode tail = current;
            current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            tail.next = current;
        }
        
        Solution sol = new Solution();
        boolean result = sol.hasCycle(head);
        System.out.println(result);

        scanner.close();
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        for (; head != null; head = head.next) {
            if (!s.add(head)) {
                return true;
            }
        }
        return false;
    }
}