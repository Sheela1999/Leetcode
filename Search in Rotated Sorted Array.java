import java.util.Scanner;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the array size
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Reading the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Reading the target value
        System.out.println("Enter the target value:");
        int target = scanner.nextInt();

        // Finding the target in the rotated sorted array
        int result = search(nums, target);

        // Printing the result
        System.out.println("Index of target: " + result);

        // Closing the scanner
        scanner.close();
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the mid element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left part is sorted
            if (nums[left] <= nums[mid]) {
                // Target is in the left sorted part
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // Target is in the right part
                    left = mid + 1;
                }
            } else { // Right part is sorted
                // Target is in the right sorted part
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // Target is in the left part
                    right = mid - 1;
                }
            }
        }

        // Target is not found
        return -1;
    }
}
