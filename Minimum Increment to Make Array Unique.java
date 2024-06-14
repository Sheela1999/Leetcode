public class MinimumMovesToUniqueArray {
    public static void main(String[] args) {
        // Step 1: Read input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        // Step 2: Sort the array
        Arrays.sort(nums);
        
        // Step 3: Initialize moves counter
        int moves = 0;
        
        // Step 4: Iterate through the array to make elements unique
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                // Calculate the needed increment
                int increment = nums[i - 1] + 1 - nums[i];
                // Increment the current element
                nums[i] += increment;
                // Add the increment to the total moves
                moves += increment;
            }
        }
        
        // Step 5: Output the result
        System.out.println("Minimum number of moves to make all elements unique: " + moves);
    }
}


class Solution {
    public int minIncrementForUnique(int[] nums) {
         Arrays.sort(nums);
        int moves = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                int increment = nums[i - 1] + 1 - nums[i];
                nums[i] += increment;
                moves += increment;
            }
        }
        return moves;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = scan.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.minIncrementForUnique(number);
        System.out.println(result);

        scan.close();
    }
}