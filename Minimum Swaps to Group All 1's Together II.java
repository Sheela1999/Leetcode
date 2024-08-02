public class MinSwapsToGroupOnes {
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        
        // Calculate the total number of 1's in the array
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        // If there are no 1's or the entire array is 1's, no swaps are needed
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        // Create an extended array to handle circular nature
        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = nums[i];
            extended[i + n] = nums[i];
        }

        // Find the initial number of 1's in the first window of size totalOnes
        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (extended[i] == 1) {
                currentOnes++;
            }
        }

        // Initialize the maximum number of 1's found in any window of size totalOnes
        int maxOnesInWindow = currentOnes;

        // Use sliding window technique to find the maximum number of 1's in any window of size totalOnes
        for (int i = 1; i < n; i++) {
            if (extended[i - 1] == 1) {
                currentOnes--;
            }
            if (extended[i + totalOnes - 1] == 1) {
                currentOnes++;
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        // The minimum swaps needed is the number of 0's in the optimal window of size totalOnes
        return totalOnes - maxOnesInWindow;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(minSwaps(nums1)); // Output: 1

        int[] nums2 = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        System.out.println(minSwaps(nums2)); // Output: 2

        int[] nums3 = {1, 1, 0, 0, 1};
        System.out.println(minSwaps(nums3)); // Output: 0
    }
}
