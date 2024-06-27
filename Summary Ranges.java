public class SummaryRanges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Reading the size of the array
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        // Reading the elements of the array
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Getting the list of ranges
        List<String> ranges = summaryRanges(nums);

        // Printing the ranges
        for (String range : ranges) {
            System.out.println(range);
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result; // Return empty list if nums is empty
        }

        // Start with the first number
        int start = nums[0];
        int end = nums[0];

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // If the current number continues the range, update the end
                end = nums[i];
            } else {
                // Otherwise, add the range to the result and start a new range
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range to the result
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }
}