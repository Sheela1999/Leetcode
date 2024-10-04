import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        // Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // We want to remove a subarray so that the remaining sum is divisible by p.
        // So, the remainder we want to remove is totalSum % p.
        long remainder = totalSum % p;

        // If the total sum is already divisible by p, we don't need to remove any elements.
        if (remainder == 0) return 0;

        // Create a map to store the mod values and their index
        HashMap<Long, Integer> modMap = new HashMap<>();
        modMap.put(0L, -1); // For cases when the sum up to some index is already divisible by p

        long currentSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            long currentMod = currentSum % p;

            // We need to remove a subarray such that (currentSum - removedSubarraySum) % p == remainder.
            long targetMod = (currentMod - remainder + p) % p;

            if (modMap.containsKey(targetMod)) {
                // Find the length of the subarray to remove
                minLength = Math.min(minLength, i - modMap.get(targetMod));
            }

            // Store the current prefix sum modulo p and its index
            modMap.put(currentMod, i);
        }

        // If no valid subarray was found, return -1
        return minLength == nums.length ? -1 : minLength;
    }
}
