public class SubarraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // to handle subarrays starting from index 0
        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            int remainder = currentSum % k;
            if (remainder < 0) {
                remainder += k; // to handle negative remainders
            }
            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        int result = subarraysDivByK(nums, k);
        System.out.println("The number of subarrays with sum divisible by " + k + " is: " + result);
        
        scanner.close();
    }
}