public class MagneticForceBetweenBalls {
    
    // Function to check if it is possible to place m balls with at least given minDistance
    private static boolean canPlaceBalls(int[] positions, int m, int minDistance) {
        int count = 1;  // Start by placing the first ball
        int lastPos = positions[0];  // Position of the last placed ball
        
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPos >= minDistance) {
                count++;
                lastPos = positions[i];  // Update the position of the last placed ball
                if (count == m) {
                    return true;  // Successfully placed all m balls
                }
            }
        }
        return false;  // Unable to place all m balls with the given minDistance
    }

    // Function to find the maximum minimum magnetic force
    public static int maxMinMagneticForce(int[] positions, int m) {
        Arrays.sort(positions);  // Sort the positions array
        int left = 1;  // Minimum possible distance
        int right = positions[positions.length - 1] - positions[0];  // Maximum possible distance
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(positions, m, mid)) {
                result = mid;  // Update the result with the current mid
                left = mid + 1;  // Try for a larger distance
            } else {
                right = mid - 1;  // Try for a smaller distance
            }
        }
        
        return result;  // The largest minimum distance possible
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input positions
        System.out.print("Enter the number of positions: ");
        int n = scanner.nextInt();
        int[] positions = new int[n];
        System.out.print("Enter the positions: ");
        for (int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
        }

        // Read number of balls
        System.out.print("Enter the number of balls: ");
        int m = scanner.nextInt();
        
        // Calculate and print the result
        int result = maxMinMagneticForce(positions, m);
        System.out.println("The maximum minimum magnetic force is: " + result);
        
        scanner.close();
    }
}