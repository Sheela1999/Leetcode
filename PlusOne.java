import java.util.Scanner;
import java.util.Arrays;

public class IncrementLargeInteger {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the last digit to the first digit
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, simply increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the digit is 9, it becomes 0 (carry over the 1 to the next digit)
            digits[i] = 0;
        }

        // If all the digits are 9, we need an extra digit at the beginning (e.g., 999 + 1 = 1000)
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of digits
        System.out.println("Enter the number of digits:");
        int numDigits = scanner.nextInt();

        // Create an array to hold the digits
        int[] digits = new int[numDigits];

        // Prompt the user to enter the digits
        System.out.println("Enter the digits:");
        for (int i = 0; i < numDigits; i++) {
            digits[i] = scanner.nextInt();
        }

        // Close the scanner to avoid resource leaks
        scanner.close();

        // Call the plusOne method with the input array and get the result
        int[] result = plusOne(digits);

        // Print the result
        System.out.println("The resulting array after incrementing is: " + Arrays.toString(result));
    }
}