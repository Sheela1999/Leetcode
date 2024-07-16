import java.util.Scanner;

public class SmallestMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        
        // Read input array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        // Find and print the smallest missing positive integer
        int result = firstMissingPositive(nums);
        System.out.println("The smallest missing positive integer is: " + result);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark numbers that are out of range and replace negative numbers with n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Use the index as a hash key and mark the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // Step 3: Find the first positive number's index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }
}
