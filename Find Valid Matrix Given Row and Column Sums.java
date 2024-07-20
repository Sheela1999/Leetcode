import java.util.Scanner;

public class MatrixFromRowColSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the rowSum array
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Read the size of the colSum array
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Initialize the rowSum array and read its elements
        int[] rowSum = new int[rows];
        System.out.println("Enter the row sums:");
        for (int i = 0; i < rows; i++) {
            rowSum[i] = scanner.nextInt();
        }

        // Initialize the colSum array and read its elements
        int[] colSum = new int[cols];
        System.out.println("Enter the column sums:");
        for (int i = 0; i < cols; i++) {
            colSum[i] = scanner.nextInt();
        }

        // Construct the matrix
        int[][] resultMatrix = constructMatrix(rowSum, colSum);

        // Print the resulting matrix
        System.out.println("Resulting matrix:");
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Method to construct the matrix based on rowSum and colSum
    public static int[][] constructMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Find the minimum value between current rowSum and colSum
                int value = Math.min(rowSum[i], colSum[j]);

                // Assign the minimum value to the matrix
                matrix[i][j] = value;

                // Subtract the assigned value from the respective rowSum and colSum
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }
        return matrix;
    }
}
