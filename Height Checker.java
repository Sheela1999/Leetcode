class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;

        for(int i = 0; i < heights.length; i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] num = new int[n];

        for(int i = 0; i < n; i++){
            num[i] = scan.nextInt();
        }

        Solution sol = new Solution();
        int res = sol.heightChecker(num);
        System.out.println(res);

        scan.close();
    }
}