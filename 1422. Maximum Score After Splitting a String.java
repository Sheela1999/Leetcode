import java.util.Scanner;

public class MaxScoreSplit {
    public static int maxScore(String s) {
        int n = s.length();
        int maxScore = 0;

        // Initialize count of zeros in the left substring and ones in the right substring
        int leftZeros = 0;
        int rightOnes = 0;

        // Count the total number of ones in the string initially (for the right substring)
        for (char c : s.toCharArray()) {
            if (c == '1') {
                rightOnes++;
            }
        }

        // Iterate through the string and calculate the score for each split
        for (int i = 0; i < n - 1; i++) {
            // Update counts based on the current character
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            // Calculate the current score and update the maximum score
            int currentScore = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a binary string: ");
        String s = scanner.nextLine();

        // Calculate and print the maximum score
        System.out.println("Maximum score: " + maxScore(s));

        scanner.close();
    }
}
