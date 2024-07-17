import java.util.*;

public class ThreeSum {
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
        
        // Find and print all unique triplets that sum up to zero
        List<List<Integer>> result = threeSum(nums);
        
        System.out.println("Unique triplets that sum to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}
