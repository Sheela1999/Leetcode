class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total number of elements in original matches m * n
        if (original.length != m * n) {
            return new int[0][];
        }

        // Initialize the 2D array
        int[][] result = new int[m][n];

        // Fill the 2D array with elements from the original array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }
}