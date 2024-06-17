class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0){
            return false;
        }

        int left = 0;
        long right = (long) Math.sqrt(c);

        while(left <= right){
            long sum = left * left + right * right;
            if(sum == c){
                return true;
            }else if(sum < c){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Solution solution = new Solution();
        boolean result = solution.judgeSquareSum(n);
        System.out.println(result);

        scanner.close();
    }
}