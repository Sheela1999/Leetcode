class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split the two sentences into arrays of words
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        // Ensure s1 is the longer sentence by swapping if necessary
        if (s1.length < s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        // Two pointers to check matching prefixes and suffixes
        int left = 0;
        int right = 0;

        // Match prefixes from the left
        while (left < s2.length && s1[left].equals(s2[left])) {
            left++;
        }

        // Match suffixes from the right
        while (right < s2.length && s1[s1.length - 1 - right].equals(s2[s2.length - 1 - right])) {
            right++;
        }

        // Check if the entire shorter sentence is matched either as a prefix or suffix
        return left + right >= s2.length;
    }
}
