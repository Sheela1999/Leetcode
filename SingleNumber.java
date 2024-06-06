class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int num : nums){
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = scan.nextInt();
        }

        Solution sol = new Solution();
        int res = sol.singleNumber(number);
        System.out.println(res);

        scan.close();
    }
}