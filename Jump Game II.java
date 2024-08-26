public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int jumps = 0;     // To store the minimum number of jumps needed
        int currentEnd = 0; // The farthest index that can be reached with the current number of jumps
        int farthest = 0;   // The farthest index that can be reached with one more jump

        // We loop through all elements except the last one
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the range we can jump to with the current number of jumps,
            // we must increase the jump count and set the current end to the farthest point we can reach
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the farthest point we can reach is already the last index or beyond, we stop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps: " + solution.jump(nums1)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Minimum jumps: " + solution.jump(nums2)); // Output: 2
    }
}
