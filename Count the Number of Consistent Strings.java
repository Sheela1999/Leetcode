import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Store the allowed characters in a set
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        int consistentCount = 0;
        
        // Check each word in the array
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            // If the word is consistent, increment the counter
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println("Consistent strings count: " + solution.countConsistentStrings(allowed1, words1)); // Output: 2

        // Test case 2
        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println("Consistent strings count: " + solution.countConsistentStrings(allowed2, words2)); // Output: 7

        // Test case 3
        String allowed3 = "cad";
        String[] words3 = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println("Consistent strings count: " + solution.countConsistentStrings(allowed3, words3)); // Output: 4
    }
}
