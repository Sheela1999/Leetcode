public class MinPatches {

    public static int minPatches(int[] nums, int n) {
        long miss = 1;  // The smallest number that we can't form yet
        int i = 0;      // Index to iterate through nums array
        int patches = 0; // Count of patches (additions) made

        while (miss <= n) {
            // If current element in nums is less than or equal to miss
            // it means we can use this number to form new sums
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i]; // Update miss to miss + nums[i]
                i++; // Move to the next number in the array
            } else {
                // If current element is greater than miss
                // we need to add (patch) a number to cover this miss
                miss += miss; // Add the smallest number we can't form yet
                patches++; // Increment the patches count
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input for the array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        // Read input for the array elements
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read input for the target number n
        System.out.print("Enter the target number n: ");
        int n = scanner.nextInt();

        // Get the minimum number of patches required
        int result = minPatches(nums, n);

        // Print the result
        System.out.println("Minimum number of patches required: " + result);

        scanner.close();
    }
}