import java.util.*;

public class Solution {
    public int minExtraChar(String s, List<String> dictionary) {
        Set<String> wordSet = new HashSet<>(dictionary); // Convert dictionary to a set for fast lookup
        int n = s.length();
        int[] dp = new int[n + 1]; // dp[i] will store the minimum number of extra characters for the substring s[0:i]

        // Initialize dp array with the worst case (no valid words, so all characters are extra)
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Traverse through the string to calculate the minimum extra characters
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            // Check all possible substrings starting from index i
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (wordSet.contains(substring)) {
                    dp[j] = Math.min(dp[j], dp[i]); // No extra characters if the substring is found in the dictionary
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + j - i); // Otherwise, consider the current substring as extra characters
                }
            }
        }

        return dp[n]; // dp[n] contains the result for the full string
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "leetscode";
        List<String> dictionary1 = Arrays.asList("leet", "code", "leetcode");
        System.out.println(solution.minExtraChar(s1, dictionary1));  // Output: 1

        // Example 2
        String s2 = "sayhelloworld";
        List<String> dictionary2 = Arrays.asList("hello", "world");
        System.out.println(solution.minExtraChar(s2, dictionary2));  // Output: 3
    }
}
