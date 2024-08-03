import java.util.Scanner;

public class FindFirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find the starting position of the target
        result[0] = findStartingPosition(nums, target);
        // Find the ending position of the target
        result[1] = findEndingPosition(nums, target);
        
        return result;
    }

    private static int findStartingPosition(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    private static int findEndingPosition(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the length of the array
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();

        // Read the elements of the array
        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Read the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Find the starting and ending positions of the target
        int[] result = searchRange(nums, target);

        // Print the result
        System.out.println("Starting and ending positions: [" + result[0] + ", " + result[1] + "]");
    }
}
