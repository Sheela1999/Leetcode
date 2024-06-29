public class ConcatenatedSubstringIndices {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int substringLength = wordLength * totalWords;

        // Count the frequency of each word in the words array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Slide a window of length substringLength over the string s
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int wordsUsed = 0;

            while (right + wordLength <= s.length()) {
                // Extract a word from the right end of the window
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // Check if the word is part of the words array
                if (wordCount.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    wordsUsed++;

                    // If the word count exceeds the required count, slide the window to the right
                    while (seenWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                        wordsUsed--;
                    }

                    // If we have used the correct number of words, record the start index
                    if (wordsUsed == totalWords) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if the word is not part of the words array
                    seenWords.clear();
                    wordsUsed = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the string s
        System.out.print("Enter the string s: ");
        String s = scanner.nextLine();

        // Reading the words array
        System.out.print("Enter the number of words: ");
        int numWords = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        String[] words = new String[numWords];
        System.out.println("Enter the words:");
        for (int i = 0; i < numWords; i++) {
            words[i] = scanner.nextLine();
        }

        // Get the starting indices of concatenated substrings
        List<Integer> indices = findSubstring(s, words);

        // Print the indices
        System.out.println("Starting indices of concatenated substrings: " + indices);

        scanner.close();
    }
}