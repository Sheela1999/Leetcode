class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;// Negative numbers cannot be palindromes
        }
        int reversed = 0;
        int original = x;

        while(x != 0){
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /=10;
        }
        return original == reversed;
        
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        Solution sol = new Solution();
        sol.isPalindrome(x);
        scan.close();
    }
}