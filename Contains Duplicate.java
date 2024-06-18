public class ContainsDuplicate {
    
    // Function to check if there are any duplicates in the array
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // Create a HashSet to store unique elements
        
        // Iterate through the array
        for (int num : nums) {
            if (set.contains(num)) { // If the set already contains the number, return true
                return true;
            }
            set.add(num); // Add the number to the set
        }
        
        return false; // If no duplicates are found, return false
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        boolean result = containsDuplicate(nums);
        
        System.out.println("Output: " + result);
        
        scanner.close();
    }
}