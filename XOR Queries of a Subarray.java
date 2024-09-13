public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Create a prefix XOR array
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        
        // Build prefix XOR array
        // prefixXOR[i] represents the XOR of elements from arr[0] to arr[i-1]
        for (int i = 1; i <= n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
        }

        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // XOR from arr[left] to arr[right] is prefixXOR[right+1] ^ prefixXOR[left]
            result[i] = prefixXOR[right + 1] ^ prefixXOR[left];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] result1 = solution.xorQueries(arr1, queries1);
        for (int res : result1) {
            System.out.print(res + " ");
        }
        System.out.println(); // Output: 2 7 14 8
        
        // Test case 2
        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        int[] result2 = solution.xorQueries(arr2, queries2);
        for (int res : result2) {
            System.out.print(res + " ");
        }
        System.out.println(); // Output: 8 0 4 4
    }
}
