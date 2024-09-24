class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Create a HashSet to store prefixes of numbers from arr1
        Set<Integer> s = new HashSet<>();
        
        // Loop through each number in arr1
        for (int x : arr1) {
            // For each number, extract prefixes by removing digits from the right
            for (; x > 0; x /= 10) {
                // Add each prefix to the HashSet
                s.add(x);
            }
        }
        
        // Initialize the answer variable to store the longest prefix length
        int ans = 0;
        
        // Loop through each number in arr2
        for (int x : arr2) {
            // For each number, extract prefixes by removing digits from the right
            for (; x > 0; x /= 10) {
                // If a prefix of the current number from arr2 exists in the HashSet
                if (s.contains(x)) {
                    // Update the answer with the maximum prefix length found so far
                    ans = Math.max(ans, String.valueOf(x).length());
                    // Break the loop if a matching prefix is found (to avoid unnecessary checks)
                    break;
                }
            }
        }
        
        // Return the length of the longest common prefix
        return ans;
    }
}
