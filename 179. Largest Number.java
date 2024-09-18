import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integer array to a string array for custom sorting
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort strings based on which combination is larger
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is '0', then all numbers are zero
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the result from the sorted string array
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {10, 2};
        System.out.println(solution.largestNumber(nums1)); // Output: "210"

        // Test case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums2)); // Output: "9534330"
    }
}
