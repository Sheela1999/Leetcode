public class NiceSubarrays {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] nums = new int[n];

        // Read the array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read the integer k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Close the scanner as we no longer need it
        scanner.close();

        // Calculate and print the number of nice subarrays
        System.out.println("Number of nice subarrays: " + countNiceSubarrays(nums, k));
    }

    public static int countNiceSubarrays(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        int[] prefixCounts = new int[nums.length + 1];
        prefixCounts[0] = 1;

        // Iterate over the elements in the array
        for (int num : nums) {
            // Update the prefix sum by checking if the current number is odd
            prefixSum += num % 2;

            // If the prefix sum is at least k, add the count of subarrays ending at the current position
            if (prefixSum >= k) {
                count += prefixCounts[prefixSum - k];
            }

            // Update the prefixCounts array with the current prefix sum
            prefixCounts[prefixSum]++;
        }

        return count;
    }
}