import java.util.Scanner;

class Solution {
    private boolean solved = false;

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private void solve(char[][] board) {
        if (solved) return;  // If already solved, return immediately
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            solve(board);
                            if (solved) return;
                            board[row][col] = '.';  
                        }
                    }
                    return; 
                }
            }
        }
        solved = true;  // Set solved to true if no empty cells are found
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[9][9];
        System.out.println("Enter the Sudoku board (use '.' for empty cells):");
        for (int i = 0; i < 9; i++) {
            String line = scanner.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        scanner.close();
        Solution sol = new Solution();
        sol.solveSudoku(board);
        
        System.out.println("The solved Sudoku board is:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
