public class MagicSquare {

    // Function to count the number of 3x3 magic square subgrids
    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;

        // Iterate over the grid, but avoid going out of bounds for 3x3 subgrids
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                // Check if the 3x3 subgrid starting at (i, j) is a magic square
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    // Function to check if a 3x3 subgrid is a magic square
    private static boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if all numbers are distinct and between 1 and 9
        boolean[] seen = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Check if the sum of rows, columns, and diagonals are equal
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum) {
                return false;
            }
        }

        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum) {
            return false;
        }
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
            return false;
        }

        return true;
    }
}