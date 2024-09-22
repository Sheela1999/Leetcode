import java.util.*;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;

        for (int i = 0; i < n; i++) {
            result.add(current);

            if (current * 10 <= n) {
                // Move to the next lexicographically smallest number by multiplying by 10
                current *= 10;
            } else {
                // If multiplying by 10 exceeds n, we increment
                if (current >= n) {
                    current /= 10;
                }
                current++;

                // Handle cases where current ends with zero
                while (current % 10 == 0) {
                    current /= 10;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int n1 = 13;
        System.out.println(solution.lexicalOrder(n1));  // Output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]

        // Test case 2
        int n2 = 2;
        System.out.println(solution.lexicalOrder(n2));  // Output: [1, 2]
    }
}
