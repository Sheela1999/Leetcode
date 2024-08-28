public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        int count = 0;

        // Traverse the grid2 and check if any island in grid2 is not fully in grid1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // Check boundaries and if the current cell is water
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }

        // If the current cell in grid2 is land but in grid1 it is water, then this cannot be a sub-island
        if (grid1[i][j] == 0) {
            return false;
        }

        // Mark the current cell as visited by setting it to 0
        grid2[i][j] = 0;

        // Recursively check all four directions
        boolean top = dfs(grid1, grid2, i - 1, j);
        boolean bottom = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        // The current island in grid2 is a sub-island only if all parts of it are in grid1
        return top && bottom && left && right;
    }
}