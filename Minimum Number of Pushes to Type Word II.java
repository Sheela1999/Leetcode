import java.util.Arrays; // Required for using Arrays.sort()

class Solution {
    public int minimumPushes(String word) {
        // Create an array to hold the frequency of each letter.
        int[] letterCounts = new int[26];
      
        // Count the frequency of each letter in the word.
        for (int i = 0; i < word.length(); ++i) {
            // Increment the count for the current letter.
            ++letterCounts[word.charAt(i) - 'a'];
        }
      
        // Sort the frequencies in ascending order.
        Arrays.sort(letterCounts);
      
        // Initialize the number of pushes to 0.
        int pushesRequired = 0;
      
        // Calculate the minimum pushes required.
        // Iterate over the sorted counts in reverse order (highest to lowest frequency).
        for (int i = 0; i < 26; ++i) {
            // The formula determines the number of pushes for each letter
            // taking into account the increasing number of button push multiplicities
            // as you move to different sets of 8 buttons.
            // The index for the counts is adjusted to start from the highest frequency.
            pushesRequired += (i / 8 + 1) * letterCounts[26 - i - 1];
        }
      
        // Return the total number of pushes required to type the word.
        return pushesRequired;
    }
}