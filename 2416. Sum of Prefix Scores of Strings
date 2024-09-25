class Solution {
    // Main function to calculate the sum of prefix scores for each word
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie(); // Create a new Trie to store words
        // Insert each word from the array into the Trie
        for (String w : words) {
            trie.insert(w); // Insert each word into the Trie
        }
        int[] ans = new int[words.length]; // Array to store the result for each word
        // For each word, calculate its prefix score
        for (int i = 0; i < words.length; ++i) {
            ans[i] = trie.search(words[i]); // Get the score for the current word
        }
        return ans; // Return the final result
    }
}

class Trie {
    // Each Trie node has an array of 26 children (one for each letter a-z) and a count variable
    private Trie[] children = new Trie[26]; // 26 possible children for each letter of the alphabet
    private int cnt; // Count of how many words pass through or end at this node

    // Method to insert a word into the Trie
    public void insert(String w) {
        Trie node = this; // Start from the root of the Trie
        // For each character in the word
        for (char c : w.toCharArray()) {
            c -= 'a'; // Convert character 'a' to 'z' into an index (0-25)
            // If the child node corresponding to the character does not exist, create it
            if (node.children[c] == null) {
                node.children[c] = new Trie(); // Create a new Trie node for this character
            }
            node = node.children[c]; // Move to the next child node
            ++node.cnt; // Increment the count at this node because the prefix passes through it
        }
    }

    // Method to calculate the prefix score for a word
    public int search(String w) {
        Trie node = this; // Start from the root of the Trie
        int ans = 0; // Initialize the answer (total prefix score) for this word
        // For each character in the word
        for (char c : w.toCharArray()) {
            c -= 'a'; // Convert character 'a' to 'z' into an index (0-25)
            // If the node does not have a child for this character, return the current score
            if (node.children[c] == null) {
                return ans; // No further prefix can be found, return current score
            }
            node = node.children[c]; // Move to the next child node
            ans += node.cnt; // Add the count at this node to the score (all words passing through this node)
        }
        return ans; // Return the total score for this word
    }
}
