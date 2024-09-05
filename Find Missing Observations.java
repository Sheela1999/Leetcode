import java.util.*;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        // Calculate the total sum we need for n + m rolls to achieve the mean
        int totalSum = mean * (n + m);
        
        // Calculate the sum of the given rolls
        int sumOfRolls = 0;
        for (int roll : rolls) {
            sumOfRolls += roll;
        }
        
        // Calculate the sum that the missing n rolls should add up to
        int missingSum = totalSum - sumOfRolls;
        
        // Check if it's possible to find such a sum (each missing roll should be between 1 and 6)
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0]; // Impossible to achieve the mean with valid dice rolls
        }
        
        // Initialize the result array for the missing rolls
        int[] result = new int[n];
        
        // Distribute the missingSum as evenly as possible across the n rolls
        int baseValue = missingSum / n; // Minimum value for each missing roll
        int remainder = missingSum % n; // Distribute the remainder
        
        for (int i = 0; i < n; i++) {
            result[i] = baseValue + (i < remainder ? 1 : 0); // Add 1 to the first 'remainder' rolls
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] rolls1 = {3, 2, 4, 3};
        int mean1 = 4;
        int n1 = 2;
        System.out.println(Arrays.toString(solution.missingRolls(rolls1, mean1, n1))); // Output: [6, 6]

        // Test case 2
        int[] rolls2 = {1, 5, 6};
        int mean2 = 3;
        int n2 = 4;
        System.out.println(Arrays.toString(solution.missingRolls(rolls2, mean2, n2))); // Output: [2, 3, 2, 2]

        // Test case 3
        int[] rolls3 = {1, 2, 3, 4};
        int mean3 = 6;
        int n3 = 4;
        System.out.println(Arrays.toString(solution.missingRolls(rolls3, mean3, n3))); // Output: []
    }
}
