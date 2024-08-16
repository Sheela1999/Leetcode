public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);  // Initial minimum value from the first array
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);  // Initial maximum value from the first array
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);

            // Calculate the possible max distance with current array
            maxDistance = Math.max(maxDistance, 
                                   Math.abs(currentArray.get(currentArray.size() - 1) - minVal));
            maxDistance = Math.max(maxDistance, 
                                   Math.abs(maxVal - currentArray.get(0)));

            // Update min and max values
            minVal = Math.min(minVal, currentArray.get(0));
            maxVal = Math.max(maxVal, currentArray.get(currentArray.size() - 1));
        }

        return maxDistance;
    }
}