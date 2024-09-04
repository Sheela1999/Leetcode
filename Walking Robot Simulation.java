import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Direction vectors for north, east, south, and west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;  // Starting position
        int direction = 0; // Start facing north (index 0 in the directions array)
        int maxDistance = 0;
        
        // Convert obstacles array to a set for faster lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        for (int command : commands) {
            if (command == -2) { // Turn left
                direction = (direction + 3) % 4;
            } else if (command == -1) { // Turn right
                direction = (direction + 1) % 4;
            } else { // Move forward
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[direction][0];
                    int newY = y + directions[direction][1];
                    
                    // Check if the new position is an obstacle
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break; // Stop moving in this direction
                    }
                    
                    // Update the robot's position
                    x = newX;
                    y = newY;
                    
                    // Calculate the square of the distance from the origin
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        
        return maxDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] commands1 = {4, -1, 3};
        int[][] obstacles1 = {};
        System.out.println(solution.robotSim(commands1, obstacles1)); // Output: 25

        // Test case 2
        int[] commands2 = {4, -1, 4, -2, 4};
        int[][] obstacles2 = {{2, 4}};
        System.out.println(solution.robotSim(commands2, obstacles2)); // Output: 65

        // Test case 3
        int[] commands3 = {6, -1, -1, 6};
        int[][] obstacles3 = {};
        System.out.println(solution.robotSim(commands3, obstacles3)); // Output: 36
    }
}
