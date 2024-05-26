import java.util.Scanner;

public class Solution {
    public int removeDuplicates(int[] nums) {
        // Check if the array is empty or has only one element
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        // Initialize the index for the next unique element
        int k = 1;

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // If the current element is not equal to the previous unique element
            if (nums[i] != nums[k - 1]) {
                // Assign the current element to the next unique position
                nums[k] = nums[i];
                // Increment the unique element counter
                k++;
            }
        }
        
        // Return the number of unique elements
        return k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] num = new int[n];
        System.out.println("Enter the elements of the array (sorted in non-decreasing order): ");
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int k = solution.removeDuplicates(num);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}