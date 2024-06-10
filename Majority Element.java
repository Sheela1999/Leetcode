class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] number = new int[n];

        for(int i = 0; i < n; i++){
            number[i] = scan.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.majorityElement(number);
        System.out.println(result);

        scan.close();
    }
}