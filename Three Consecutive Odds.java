public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the length of the array
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[n];

        // Read the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Check if there are three consecutive odd numbers
        boolean result = hasThreeConsecutiveOdds(arr);

        // Print the result
        if (result) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        scanner.close();
    }

    // Function to check for three consecutive odd numbers
    public static boolean hasThreeConsecutiveOdds(int[] arr) {
        // Iterate through the array up to the third-to-last element
        for (int i = 0; i < arr.length - 2; i++) {
            // Check if the current element and the next two elements are odd
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true; // Return true if three consecutive odds are found
            }
        }
        return false; // Return false if no such triplet is found
    }
}