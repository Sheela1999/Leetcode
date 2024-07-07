import java.util.Scanner;

public class Solution {
    // Method to calculate the maximum number of water bottles you can drink
    public int numWaterBottles(int numBottles, int numExchange) {
        // Initialize the total number of bottles drunk to the initial number of bottles
        int totalDrunk = numBottles;

        // Loop as long as there are enough empty bottles to exchange for at least one full bottle
        while (numBottles >= numExchange) {
            // Calculate the number of new full bottles from the empty ones
            int newBottles = numBottles / numExchange;
            
            // Calculate the remaining empty bottles after the exchange
            int remainingEmpty = numBottles % numExchange;
            
            // Add the new full bottles to the total number of bottles drunk
            totalDrunk += newBottles;
            
            // Update the number of bottles to the sum of new full bottles and remaining empty bottles
            numBottles = newBottles + remainingEmpty;
        }

        // Return the total number of bottles drunk
        return totalDrunk;    
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Read the initial number of water bottles from the user
        int n = scanner.nextInt();
        // Read the number of empty bottles needed for one full bottle from the user
        int e = scanner.nextInt();

        // Create an instance of the Solution class
        Solution solution = new Solution();
        // Call the numWaterBottles method with the inputs and store the result
        int result = solution.numWaterBottles(n, e);
        // Print the result
        System.out.println(result);

        // Close the scanner
        scanner.close();
    }
}
