class Solution {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
             int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] { map.get(complement), i };
            }
             map.put(nums[i], i);
    }
      throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int target = scan.nextInt();
        
        // Find the two sum solution
        try {
            int[] result = twoSum(nums, target);
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scan.close();
    }
}