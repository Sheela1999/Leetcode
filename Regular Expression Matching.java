public class RegexMatching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        
        System.out.print("Enter the pattern: ");
        String p = scanner.nextLine();
        
        boolean result = isMatch(s, p);
        System.out.println("Does the string match the pattern? " + result);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* which can match an empty string
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // If p[j-1] is '*', it can match zero or more of the preceding element
                    // If it matches zero (dp[i][j-2]), or matches one or more (dp[i-1][j])
                    dp[i][j] = dp[i][j - 2] || (matches(s, p, i - 1, j - 2) && dp[i - 1][j]);
                } else {
                    // If p[j-1] is '.' or p[j-1] matches s[i-1]
                    dp[i][j] = matches(s, p, i - 1, j - 1) && dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }

    // Helper function to check if characters match (considering '.')
    private static boolean matches(String s, String p, int i, int j) {
        if (j < 0) return false;
        if (p.charAt(j) == '.') return true;
        return s.charAt(i) == p.charAt(j);
    }
}


Example Walkthrough
Example 1: s = "aa", p = "a"
dp[0][0] = true (empty string matches empty pattern).
dp[1][1] = false because 'a' does not match 'aa'.
Result: false.

Example 2: s = "aa", p = "a*"
dp[0][0] = true.
dp[0][2] = true because a* can match an empty string.
dp[1][1] = true because 'a' matches 'a'.
dp[2][2] = true because a* can match 'aa'.
Result: true.

Example 3: s = "ab", p = ".*"
dp[0][0] = true.
dp[0][2] = true because .* can match an empty string.
dp[1][1] = true because '.' matches 'a'.
dp[2][2] = true because .* matches 'ab'.
Result: true.