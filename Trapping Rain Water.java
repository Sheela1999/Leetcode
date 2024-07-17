import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input array size
        System.out.print("Enter the size of the elevation map: ");
        int n = scanner.nextInt();
        
        int[] height = new int[n];
        
        // Read input array elements
        System.out.println("Enter the elements of the elevation map: ");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        
        // Compute and print the amount of trapped water
        int result = trap(height);
        System.out.println("Total trapped water: " + result);
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        
        return totalWater;
    }
}
