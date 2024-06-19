public class ContainsNearbyDuplicate {

    // Function to check if there are any duplicates within k distance
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Create a HashMap to store the element and its index
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) { // Check if the difference in indices is less than or equal to k
                    return true;
                }
            }
            map.put(nums[i], i); // Update the index of the element in the map
        }
        
        return false; // If no such pair is found, return false
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
        
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();
        
        boolean result = containsNearbyDuplicate(nums, k);
        
        System.out.println("Output: " + result);
        
        scanner.close();
    }
}