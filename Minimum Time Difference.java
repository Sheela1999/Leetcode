import java.util.*;

public class Solution {
    
    // Method to convert "HH:MM" to minutes
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public int findMinDifference(List<String> timePoints) {
        // Sort the time points
        Collections.sort(timePoints);

        // Initialize the minimum difference to a large value
        int minDifference = Integer.MAX_VALUE;

        // Convert first time point to compare with the last one for circular comparison
        int firstTimeInMinutes = convertToMinutes(timePoints.get(0));
        int previousTimeInMinutes = firstTimeInMinutes;

        // Compare consecutive time points
        for (int i = 1; i < timePoints.size(); i++) {
            int currentTimeInMinutes = convertToMinutes(timePoints.get(i));
            minDifference = Math.min(minDifference, currentTimeInMinutes - previousTimeInMinutes);
            previousTimeInMinutes = currentTimeInMinutes;
        }

        // Handle circular difference between the first and the last time point
        int lastTimeInMinutes = convertToMinutes(timePoints.get(timePoints.size() - 1));
        minDifference = Math.min(minDifference, 1440 - (lastTimeInMinutes - firstTimeInMinutes));

        return minDifference;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        System.out.println(solution.findMinDifference(timePoints1));  // Output: 1

        // Test case 2
        List<String> timePoints2 = Arrays.asList("00:00", "23:59", "00:00");
        System.out.println(solution.findMinDifference(timePoints2));  // Output: 0
    }
}
