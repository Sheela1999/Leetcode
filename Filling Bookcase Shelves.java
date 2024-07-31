import java.util.Scanner;

public class BookcaseShelves {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the number of books
        System.out.println("Enter the number of books:");
        int n = scanner.nextInt();

        // Initialize an array to store the books' dimensions
        int[][] books = new int[n][2];

        // Prompt user to enter the dimensions of each book
        System.out.println("Enter the thickness and height of each book:");
        for (int i = 0; i < n; i++) {
            books[i][0] = scanner.nextInt(); // thickness of the ith book
            books[i][1] = scanner.nextInt(); // height of the ith book
        }

        // Prompt user to enter the shelf width
        System.out.println("Enter the shelf width:");
        int shelfWidth = scanner.nextInt();

        // Call the method to get the minimum height of the bookcase
        int result = minHeightShelves(books, shelfWidth);

        // Print the result
        System.out.println("Minimum height of the bookcase: " + result);

        // Close the scanner
        scanner.close();
    }

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // dp[i] represents the minimum height to place the first i books
        int[] dp = new int[n + 1];
        dp[0] = 0;

        // Iterate over each book to determine the minimum height of the shelves
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            dp[i] = Integer.MAX_VALUE;

            // Iterate backwards to consider placing books on the current shelf
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) break;
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        
        // Return the minimum height of the bookcase to place all books
        return dp[n];
    }
}
