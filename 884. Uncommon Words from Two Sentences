import java.util.*;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Use a HashMap to store the frequency of words
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Helper method to count words in a sentence
        addWordsToMap(s1, wordCount);
        addWordsToMap(s2, wordCount);
        
        // List to store uncommon words
        List<String> uncommonWords = new ArrayList<>();
        
        // Find words that have appeared exactly once
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
        
        // Convert list to array
        return uncommonWords.toArray(new String[0]);
    }

    // Helper method to add words from a sentence to the map
    private void addWordsToMap(String sentence, Map<String, Integer> wordCount) {
        String[] words = sentence.split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s1, s2))); 
        // Output: ["sweet", "sour"]

        // Test case 2
        String s1_2 = "apple apple";
        String s2_2 = "banana";
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s1_2, s2_2))); 
        // Output: ["banana"]
    }
}
