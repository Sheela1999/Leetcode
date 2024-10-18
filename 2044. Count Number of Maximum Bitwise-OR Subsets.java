import java.util.*;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;

        // Step 1: Find the maximum bitwise OR possible
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Use backtracking to find the number of subsets that achieve the max OR
        return countSubsetsWithMaxOr(nums, 0, 0, maxOr);
    }

    // Backtracking function to count subsets that give the max OR
    private int countSubsetsWithMaxOr(int[] nums, int idx, int currentOr, int maxOr) {
        if (idx == nums.length) {
            // If we have reached the end, check if the current subset OR equals maxOr
            return currentOr == maxOr ? 1 : 0;
        }

        // Case 1: Include the current number in the OR
        int include = countSubsetsWithMaxOr(nums, idx + 1, currentOr | nums[idx], maxOr);
        
        // Case 2: Exclude the current number from the OR
        int exclude = countSubsetsWithMaxOr(nums, idx + 1, currentOr, maxOr);

        // Return the sum of both cases
        return include + exclude;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] nums1 = {3, 1};
        System.out.println(solution.countMaxOrSubsets(nums1)); // Output: 2

        int[] nums2 = {2, 2, 2};
        System.out.println(solution.countMaxOrSubsets(nums2)); // Output: 7

        int[] nums3 = {3, 2, 1, 5};
        System.out.println(solution.countMaxOrSubsets(nums3)); // Output: 6
    }
}
