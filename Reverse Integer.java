public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input integer
        System.out.print("Enter an integer: ");
        int x = scanner.nextInt();

        // Reverse the digits of the integer
        int result = reverse(x);

        // Print the result
        System.out.println("Reversed integer: " + result);

        scanner.close();
    }

    // Function to reverse the digits of an integer
    public static int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10; // Extract the last digit
            x /= 10; // Remove the last digit from x

            // Check for overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Return 0 in case of overflow
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Return 0 in case of underflow
            }

            reversed = reversed * 10 + pop; // Update reversed with the new digit
        }
        
        return reversed;
    }
}