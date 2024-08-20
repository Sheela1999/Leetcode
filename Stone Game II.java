public class StoneGameII {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        // Calculate the suffix sum array
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Fill the dp table
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                if (i + 2 * M >= n) {
                    dp[i][M] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
}