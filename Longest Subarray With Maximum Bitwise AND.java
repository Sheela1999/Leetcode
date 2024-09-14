public class Solution {
    public int longestSubarray(int[] nums) {
        // Find the maximum value in the array
        int maxValue = nums[0];
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int maxLength = 0;
        int currentLength = 0;

        // Iterate through the array and find the longest subarray with maxValue
        for (int num : nums) {
            if (num == maxValue) {
                currentLength++;  // Keep track of subarray length when we see maxValue
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;  // Reset if the number is not maxValue
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println(solution.longestSubarray(nums1)); // Output: 2

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.longestSubarray(nums2)); // Output: 1
    }
}
