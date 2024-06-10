class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for(int i = 0; i < columnTitle.length(); i++){
            char currentChar = columnTitle.charAt(i);
            int currentValue = currentChar - 'A' + 1;
            result = result * 26 + currentValue;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        Solution sol = new Solution();
        int res = sol.titleToNumber(str);
        System.out.println(res);

        scan.close();
    }
}