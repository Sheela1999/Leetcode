import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        if (n != target.length()) {
            return -1;
        }

        int INF = Integer.MAX_VALUE / 2; // Use a large number to represent infinity

        // Initialize the cost matrix with INF and 0 for diagonal
        int[][] conversionCost = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(conversionCost[i], INF);
            conversionCost[i][i] = 0;
        }

        // Populate the cost matrix with the given conversions
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            conversionCost[from][to] = Math.min(conversionCost[from][to], cost[i]);
        }

        // Apply Floyd-Warshall to find the minimum cost between all pairs of characters
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (conversionCost[i][k] != INF && conversionCost[k][j] != INF) {
                        conversionCost[i][j] = Math.min(conversionCost[i][j], conversionCost[i][k] + conversionCost[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;

        // Calculate the total cost to convert source to target
        for (int i = 0; i < n; i++) {
            char sChar = source.charAt(i);
            char tChar = target.charAt(i);
            if (sChar != tChar) {
                int sIndex = sChar - 'a';
                int tIndex = tChar - 'a';
                if (conversionCost[sIndex][tIndex] == INF) {
                    return -1; // Impossible to convert
                }
                totalCost += conversionCost[sIndex][tIndex];
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source string: ");
        String source = scanner.nextLine();
        System.out.println("Enter target string: ");
        String target = scanner.nextLine();

        System.out.println("Enter number of conversions: ");
        int n = scanner.nextInt();

        char[] original = new char[n];
        char[] changed = new char[n];
        int[] cost = new int[n];

        System.out.println("Enter original characters: ");
        for (int i = 0; i < n; i++) {
            original[i] = scanner.next().charAt(0);
        }

        System.out.println("Enter changed characters: ");
        for (int i = 0; i < n; i++) {
            changed[i] = scanner.next().charAt(0);
        }

        System.out.println("Enter costs: ");
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        long result = solution.minimumCost(source, target, original, changed, cost);
        System.out.println("Minimum cost to convert source to target: " + result);

        scanner.close();
    }
}
