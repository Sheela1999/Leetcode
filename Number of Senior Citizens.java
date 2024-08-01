import java.util.Scanner;

public class PassengerDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of passengers
        System.out.println("Enter the number of passengers:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Array to store the passenger details
        String[] details = new String[n];

        // Reading the details of each passenger
        System.out.println("Enter the details of each passenger:");
        for (int i = 0; i < n; i++) {
            details[i] = scanner.nextLine();
        }

        // Initialize the count of passengers older than 60
        int count = 0;

        // Loop through each passenger detail
        for (String detail : details) {
            // Extract the age part of the string
            String ageStr = detail.substring(11, 13);
            // Convert the age string to an integer
            int age = Integer.parseInt(ageStr);
            // Check if the age is strictly more than 60
            if (age > 60) {
                count++;
            }
        }

        // Print the result
        System.out.println("Number of passengers older than 60: " + count);

        // Close the scanner
        scanner.close();
    }
}
