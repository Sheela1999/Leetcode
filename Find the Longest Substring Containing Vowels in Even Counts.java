import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTheLongestSubstring(String s) {
        // State variable for tracking the parity of vowels
        int state = 0;
        // Map to store the first occurrence of a specific state
        Map<Integer, Integer> stateToIndex = new HashMap<>();
        // Initialize with the base case: state 0 at index -1
        stateToIndex.put(0, -1);
        int maxLength = 0;

        // Iterate over the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Update state based on the vowel encountered
            if (c == 'a') {
                state ^= (1 << 0);  // Toggle the first bit for 'a'
            } else if (c == 'e') {
                state ^= (1 << 1);  // Toggle the second bit for 'e'
            } else if (c == 'i') {
                state ^= (1 << 2);  // Toggle the third bit for 'i'
            } else if (c == 'o') {
                state ^= (1 << 3);  // Toggle the fourth bit for 'o'
            } else if (c == 'u') {
                state ^= (1 << 4);  // Toggle the fifth bit for 'u'
            }

            // If this state has been seen before, calculate the length of the substring
            if (stateToIndex.containsKey(state)) {
                maxLength = Math.max(maxLength, i - stateToIndex.get(state));
            } else {
                // Otherwise, store the first occurrence of this state
                stateToIndex.put(state, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "eleetminicoworoep";
        System.out.println(solution.findTheLongestSubstring(s1)); // Output: 13

        // Test case 2
        String s2 = "leetcodeisgreat";
        System.out.println(solution.findTheLongestSubstring(s2)); // Output: 5

        // Test case 3
        String s3 = "bcbcbc";
        System.out.println(solution.findTheLongestSubstring(s3)); // Output: 6
    }
}
