public class MinDifference {
    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array with the given size
        int[] nums = new int[n];

        // Read the elements of the array...
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Close the scanner as we no longer need it
        scanner.close();

        // Get the minimum difference after at most 3 moves
        int result = minDifference(nums);

        // Print the result
        System.out.println("The minimum difference is: " + result);
    }

    public static int minDifference(int[] nums) {
        // If there are 4 or fewer elements, we can make them all the same with at most 3 moves
        if (nums.length <= 4) {
            return 0;
        }

        // Sort the array to get the smallest and largest elements easily
        Arrays.sort(nums);

        // The possible moves to get the minimum difference:
        // 1. Change the three largest elements to the fourth largest element.
        // 2. Change the two largest elements to the third largest and the smallest to the second smallest.
        // 3. Change the largest to the second largest and the two smallest to the third smallest.
        // 4. Change the three smallest elements to the fourth smallest element.

        // Calculate the minimum difference for all the above cases
        int case1 = nums[nums.length - 4] - nums[0];
        int case2 = nums[nums.length - 3] - nums[1];
        int case3 = nums[nums.length - 2] - nums[2];
        int case4 = nums[nums.length - 1] - nums[3];

        // Return the minimum of the four cases
        return Math.min(Math.min(case1, case2), Math.min(case3, case4));
    }
}