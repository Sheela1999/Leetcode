import java.util.Scanner;

class Solution {
    public double averageWaitingTime(int[][] customers) {
        long currentTime = 0; // Use long to handle large sums // Tracks the current time in the kitchen
        long totalWaitingTime = 0; // Use long to handle large sums // Accumulates the total waiting time of all customers

    // Iterate over each customer in the order they arrive
        for (int[] customer : customers) {
            int arrivalTime = customer[0]; // The arrival time of the current customer
            int preparationTime = customer[1]; // The preparation time needed for the current customer

            // The chef starts preparing the order when they are idle or the customer arrives
            currentTime = Math.max(currentTime, arrivalTime);
            // The waiting time for the current customer
            int waitingTime = (int)(currentTime + preparationTime - arrivalTime);
            // Update the total waiting time
            totalWaitingTime += waitingTime;
            // Update the current time to reflect the time after preparing this customer's order
            currentTime += preparationTime;
        }

        // Calculate the average waiting time
        return (double) totalWaitingTime / customers.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] customers = new int[n][2];
        for (int i = 0; i < n; i++) {
            customers[i][0] = scanner.nextInt();
            customers[i][1] = scanner.nextInt();
        }

        scanner.close();

        Solution solution = new Solution();
        double result = solution.averageWaitingTime(customers);
        System.out.printf("%.5f\n", result);
    }
}
