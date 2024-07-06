import java.util.Scanner;

public class StringToInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input string
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        // Convert the string to an integer
        int result = myAtoi(s);

        // Output the result
        System.out.println("Converted integer: " + result);
    }

    public static int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int total = 0;
        int n = s.length();

        // Step 1: Remove leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Handle sign if any
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Convert numbers and avoid non-digit characters
        while (index < n) {
            char currentChar = s.charAt(index);
            if (!Character.isDigit(currentChar)) {
                break;
            }

            // Convert char to int
            int digit = currentChar - '0';

            // Step 4: Handle overflow and underflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}