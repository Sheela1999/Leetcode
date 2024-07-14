import java.util.Scanner;

public class MaxWaterContainer {

    public static int maxArea(int[] height) {
        int maxArea = 0; // Variable to store the maximum area
        int left = 0; // Pointer at the beginning of the array
        int right = height.length - 1; // Pointer at the end of the array
        
        // While left pointer is less than right pointer
        while (left < right) {
            // Calculate the current area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            // Update maxArea if the current area is greater
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer that points to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea; // Return the maximum area
    }

    public static void main(String[] args) {
        // Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt(); // Read the number of elements
        int[] height = new int[n]; // Create an array of size n
        
        System.out.println("Enter the elements of the array:");
        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        
        // Call the maxArea function and print the result
        System.out.println("The maximum amount of water the container can store is: " + maxArea(height));
    }
}
