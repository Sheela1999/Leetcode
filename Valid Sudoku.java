import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        // Create sets to track seen numbers in rows, columns, and 3x3 sub-boxes
        Set<String> seen = new HashSet<>();

        // Iterate through each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    // Check for duplicates in rows, columns, and 3x3 sub-boxes
                    if (!seen.add(current + " in row " + i) ||
                        !seen.add(current + " in column " + j) ||
                        !seen.add(current + " in box " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][9];

        // Read the 9x9 board from input
        System.out.println("Enter the Sudoku board row by row (use '.' for empty cells):");
        for (int i = 0; i < 9; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // Check if the Sudoku board is valid
        boolean isValid = isValidSudoku(board);

        // Print the result
        System.out.println("The Sudoku board is " + (isValid ? "valid" : "invalid"));
    }
}
