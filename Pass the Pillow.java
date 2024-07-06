import java.util.Scanner;

public class PillowPass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of people (n) and the time (t) from the input
        System.out.print("Enter the number of people (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the time in seconds (t): ");
        int t = scanner.nextInt();

        // Determine the index of the person holding the pillow after t seconds
        int position = findPillowHolder(n, t);

        // Output the result
        System.out.println("The person holding the pillow after " + t + " seconds is: " + position);
    }

    public static int findPillowHolder(int n, int t) {
        // Calculate the effective time considering the direction reversals
        int cycleLength = (n - 1) * 2;  // The pillow goes from 1 to n and back to 1 in (n-1)*2 seconds
        t = t % cycleLength;

        // Determine the position of the pillow after the remaining time
        if (t < n) {
            return t + 1;  // Forward direction: t seconds, add 1 for 1-based index
        } else {
            return n - (t - n + 1);  // Reverse direction: n-1, n-2, ..., add 1 for 1-based index
        }
    }
}
