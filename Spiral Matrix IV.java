// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initialize the matrix with -1 values
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Define the boundaries for the spiral traversal
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        ListNode current = head;

        // Traverse the matrix in a spiral order
        while (current != null && top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right && current != null; i++) {
                matrix[top][i] = current.val;
                current = current.next;
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--; // Move the right boundary left

            // Traverse from right to left along the bottom row
            for (int i = right; i >= left && current != null; i--) {
                matrix[bottom][i] = current.val;
                current = current.next;
            }
            bottom--; // Move the bottom boundary up

            // Traverse from bottom to top along the left column
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++; // Move the left boundary right
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(8);
        head1.next.next.next.next.next = new ListNode(1);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int[][] result1 = solution.spiralMatrix(3, 5, head1);
        printMatrix(result1);  // Expected output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]

        // Example 2
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        int[][] result2 = solution.spiralMatrix(1, 4, head2);
        printMatrix(result2);  // Expected output: [[0,1,2,-1]]
    }

    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
