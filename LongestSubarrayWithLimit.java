public class LongestSubarrayWithLimit {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] nums = new int[n];

        // Read the elements of the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read the limit
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();

        // Call the function to get the result
        int result = longestSubarray(nums, limit);

        // Print the result
        System.out.println("The size of the longest subarray is: " + result);

        // Close the scanner
        scanner.close();
    }

    public static int longestSubarray(int[] nums, int limit) {
        // Deques to store the indexes of max and min elements in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0;  // Left boundary of the window
        int result = 0;  // Result to store the size of the longest subarray

        for (int right = 0; right < nums.length; right++) {
            // Maintain the decreasing order in maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            // Maintain the increasing order in minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            
            // Add current element's index to both deques
            maxDeque.addLast(right);
            minDeque.addLast(right);
            
            // Ensure the window is valid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            
            // Update the result
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}

//This is giving error like Time limit exceeded

public class LongestSubarrayWithLimit {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] nums = new int[n];

        // Read the elements of the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read the limit
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();

        // Call the function to get the result
        int result = longestSubarray(nums, limit);

        // Print the result
        System.out.println("The size of the longest subarray is: " + result);

        // Close the scanner
        scanner.close();
    }

    public static int longestSubarray(int[] nums, int limit) {
        int left = 0; // Left boundary of the window
        int maxLen = 0; // Result to store the size of the longest subarray

        for (int right = 0; right < nums.length; right++) {
            int minVal = nums[right]; // Initialize minVal
            int maxVal = nums[right]; // Initialize maxVal
            
            // Update minVal and maxVal by checking all elements in the current window
            for (int i = left; i <= right; i++) {
                minVal = Math.min(minVal, nums[i]);
                maxVal = Math.max(maxVal, nums[i]);
            }

            // If the current window is not valid, move the left boundary to the right
            while (maxVal - minVal > limit) {
                left++;
                // Update minVal and maxVal by checking all elements in the new window
                minVal = nums[left];
                maxVal = nums[left];
                for (int i = left; i <= right; i++) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            }
            
            // Update the maximum length of valid subarray
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}