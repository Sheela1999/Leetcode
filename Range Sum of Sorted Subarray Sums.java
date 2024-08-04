import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubarraySumRange {

    public static int subarraySumRange(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        ArrayList<Integer> subarraySums = new ArrayList<>();

        // Generate all possible subarray sums
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                subarraySums.add(currentSum);
            }
        }

        // Sort the subarray sums in non-decreasing order
        Collections.sort(subarraySums);

        // Calculate the sum from index left to right (1-based index)
        long sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum = (sum + subarraySums.get(i)) % MOD;
        }

        return (int) sum;
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

        // Read the values of left and right
        System.out.print("Enter the value of left: ");
        int left = scanner.nextInt();
        System.out.print("Enter the value of right: ");
        int right = scanner.nextInt();

        // Calculate the sum of subarray sums in the given range
        int result = subarraySumRange(nums, n, left, right);

        // Print the result
        System.out.println("The sum of the numbers from index " + left + " to " + right + " is: " + result);
    }
}
