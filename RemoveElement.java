import java.util.Scanner;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val, keep it
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        // Return the number of elements that are not equal to val
        return k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Read the array elements
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read the value to remove
        System.out.print("Enter the value to remove: ");
        int val = scanner.nextInt();

        // Create a Solution instance and call the removeElement method
        Solution solution = new Solution();
        int k = solution.removeElement(nums, val);

        // Print the result
        System.out.println("Number of elements remaining: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // Close the scanner
        scanner.close();
    }
}