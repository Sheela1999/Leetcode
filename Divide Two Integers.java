public class IntegerDivision {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);

        // Read the dividend
        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();

        // Read the divisor
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Call the function to get the quotient
        int result = divide(dividend, divisor);

        // Print the result
        System.out.println("The quotient is: " + result);

        // Close the scanner
        scanner.close();
    }

    public static int divide(int dividend, int divisor) {
        // Handle edge cases for overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to positive
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Initialize quotient
        int quotient = 0;

        // Subtract the divisor from the dividend until the dividend is less than the divisor
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply the sign to the quotient
        return negative ? -quotient : quotient;
    }
}