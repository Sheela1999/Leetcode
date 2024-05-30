class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }

        int[] stairs = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;

        for(int i = 2; i <=n ; i++){
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n];
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int stair = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.climbStairs(stair);
        System.out.println(result);

        scanner.close();
    }
}