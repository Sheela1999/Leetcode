// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1}; // Return early if there are fewer than three nodes
        }

        int first = -1, last = -1, minDistance = Integer.MAX_VALUE;
        int index = 1; // Start index at 1 since we begin from the second node
        List<Integer> criticalPoints = new ArrayList<>();

        // Initialize pointers to traverse the list
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        // Traverse the list
        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                criticalPoints.add(index);
                if (first == -1) {
                    first = index;
                } else {
                    minDistance = Math.min(minDistance, index - last);
                }
                last = index;
            }
            // Move to the next set of nodes
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        // If there are fewer than two critical points, return [-1, -1]
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        // Calculate the maximum distance between the first and last critical points
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        return new int[]{minDistance, maxDistance};
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // Read input values
        System.out.println("Enter the values of the linked list nodes separated by spaces:");
        String[] values = scanner.nextLine().split(" ");
        
        // Create the linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value));
            current = current.next;
        }
        
        Solution sol = new Solution();
        int[] result = sol.nodesBetweenCriticalPoints(dummy.next);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}