public class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;  // Since we start from the first lexicographical number, we decrement k

        while (k > 0) {
            // Calculate the steps between `current` and `current + 1`
            long steps = calculateSteps(n, current, current + 1);

            if (steps <= k) {
                // If the number of steps is less than or equal to k, move to the next sibling
                current++;
                k -= steps;
            } else {
                // Otherwise, move down to the first child
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long calculateSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int n1 = 13, k1 = 2;
        System.out.println(solution.findKthNumber(n1, k1));  // Output: 10

        // Test case 2
        int n2 = 1, k2 = 1;
        System.out.println(solution.findKthNumber(n2, k2));  // Output: 1
    }
}
