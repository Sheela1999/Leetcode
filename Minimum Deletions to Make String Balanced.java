import java.util.Scanner;

public class BalancedString {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the string
        System.out.println("Enter the string consisting only of 'a' and 'b':");
        String s = scanner.nextLine();

        // Call the method to get the minimum deletions needed
        int result = minDeletionsToBalance(s);

        // Print the result
        System.out.println("Minimum deletions needed to balance the string: " + result);

        // Close the scanner
        scanner.close();
    }

    public static int minDeletionsToBalance(String s) {
        // Initialize counters for 'a's to the right and 'b's to the left
        int totalA = 0;
        int totalB = 0;

        // Count the total number of 'a's in the string
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA++;
            }
        }

        // Initialize the minimum deletions to the total number of 'a's
        // (assuming we delete all 'a's to make the string balanced)
        int minDeletions = totalA;

        // Traverse the string to calculate the minimum deletions
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA--;  // If we encounter 'a', decrement the count of 'a's to the right
            } else {
                totalB++;  // If we encounter 'b', increment the count of 'b's to the left
            }

            // Calculate the current deletions needed to balance the string
            // totalB + totalA gives the sum of 'b's to the left and 'a's to the right
            minDeletions = Math.min(minDeletions, totalB + totalA);
        }

        // Return the minimum deletions needed
        return minDeletions;
    }
}
