import java.util.*;

public class MinimumKBitFlips {
    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Read the array length
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the binary array
        int[] nums = new int[n];

        // Read the elements of the binary array
        System.out.println("Enter the elements of the array (0s and 1s): ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read the value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Call the function to find the minimum number of k-bit flips
        int result = minKBitFlips(nums, k);

        // Print the result
        System.out.println("Minimum number of k-bit flips required: " + result);
    }

    // Function to calculate the minimum number of k-bit flips
    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;       // Length of the binary array
        int flips = 0;             // To count the number of flips
        int flipCount = 0;         // To track the current flip state
        int[] isFlipped = new int[n];  // Array to keep track of flip operations

        // Iterate through each element in the binary array
        for (int i = 0; i < n; i++) {
            // If the current element is out of the flipping window, revert the flip count
            if (i >= k) {
                flipCount ^= isFlipped[i - k];
            }

            // If the current element needs to be flipped (i.e., it's 0 if flipCount is even, or 1 if odd)
            if ((nums[i] ^ flipCount) == 0) {
                // If flipping is not possible (i.e., not enough elements left for a k-bit flip)
                if (i + k > n) {
                    return -1;
                }

                // Flip the current element
                flips++;            // Increment the flip count
                flipCount ^= 1;     // Update the flip state
                isFlipped[i] = 1;   // Mark this position as flipped
            }
        }

        // Return the total number of flips
        return flips;
    }
}
