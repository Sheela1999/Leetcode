import java.util.Arrays;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Binary search on the distance
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Step 3: Count the number of pairs with distance <= mid
            int count = countPairs(nums, mid);
            
            // Step 4: Adjust the binary search range
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
    
    private int countPairs(int[] nums, int target) {
        int count = 0;
        int left = 0;
        
        for (int right = 1; right < nums.length; right++) {
            // Find the first `left` such that nums[right] - nums[left] <= target
            while (nums[right] - nums[left] > target) {
                left++;
            }
            count += right - left;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 3, 1};
        int k1 = 1;
        System.out.println(solution.smallestDistancePair(nums1, k1)); // Output: 0
        
        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println(solution.smallestDistancePair(nums2, k2)); // Output: 0
        
        int[] nums3 = {1, 6, 1};
        int k3 = 3;
        System.out.println(solution.smallestDistancePair(nums3, k3)); // Output: 5
    }
}
