import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyNumbersMatrix {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input matrix dimensions
        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();
        
        int[][] matrix = new int[m][n];
        
        // Input matrix elements
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Find lucky numbers
        List<Integer> luckyNumbers = findLuckyNumbers(matrix);
        
        // Print lucky numbers
        System.out.println("Lucky numbers in the matrix: " + luckyNumbers);
        
        scanner.close();
    }
    
    public static List<Integer> findLuckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        
        // Iterate over each row to find the minimum elements
        for (int i = 0; i < matrix.length; i++) {
            int minElement = matrix[i][0];
            int minIndex = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < minElement) {
                    minElement = matrix[i][j];
                    minIndex = j;
                }
            }
            
            // Check if the found minimum element is the maximum in its column
            boolean isLucky = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minIndex] > minElement) {
                    isLucky = false;
                    break;
                }
            }
            
            // If it is a lucky number, add to the list
            if (isLucky) {
                luckyNumbers.add(minElement);
            }
        }
        
        return luckyNumbers;
    }
}
