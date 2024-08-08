public class SpiralMatrix {
    
    // Function to return the spiral order of coordinates
    public static int[][] spiralOrder(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[] dr = {0, 1, 0, -1};  // Direction arrays for row movement
        int[] dc = {1, 0, -1, 0};  // Direction arrays for column movement
        int len = 0, d = 0, k = 0;
        
        result[k++] = new int[]{rStart, cStart};
        
        while (k < rows * cols) {
            if (d == 0 || d == 2) {
                len++;
            }
            for (int i = 0; i < len; i++) {
                rStart += dr[d];
                cStart += dc[d];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[k++] = new int[]{rStart, cStart};
                }
            }
            d = (d + 1) % 4; // Change direction
        }
        
        return result;
    }
}