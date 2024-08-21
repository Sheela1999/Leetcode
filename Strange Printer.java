public class StrangePrinter {

    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        // dp[i][j] will hold the minimum number of turns needed to print s[i..j]
        int[][] dp = new int[n][n];
        
        // Loop over the substring lengths
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = len; // Maximum turns required if all characters are different
                
                // Try every possible split point
                for (int k = i; k < j; k++) {
                    int totalTurns = dp[i][k] + dp[k + 1][j];
                    // If the characters at the split are the same, we can reduce one turn
                    if (s.charAt(k) == s.charAt(j)) {
                        totalTurns--;
                    }
                    dp[i][j] = Math.min(dp[i][j], totalTurns);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}