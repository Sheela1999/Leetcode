class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];  // Update minPrice if current price is lower
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;  // Update maxProfit if we find a higher profit
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();
        int[] prices = new int[n];

        System.out.println("Enter the prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.maxProfit(prices);
        System.out.println("The maximum profit is: " + result);

        scanner.close();
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, mi = prices[0];
        for (int v : prices) {
            ans = Math.max(ans, v - mi);
            mi = Math.min(mi, v);
        }
        return ans;
    }
}