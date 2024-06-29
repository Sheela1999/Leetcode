public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        // Check if n is positive and a power of two
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the integer n
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        // Check if n is a power of two
        boolean result = isPowerOfTwo(n);

        // Print the result
        System.out.println("Is " + n + " a power of two? " + result);

        scanner.close();
    }
}