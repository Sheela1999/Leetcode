public class Solution {
    // Instance method to replace words based on the dictionary
    public String replaceWords(List<String> dictionary, String sentence) {
        // Sort the dictionary by length of the root word
        Collections.sort(dictionary, (a, b) -> a.length() - b.length());

        // Split the sentence into words
        String[] words = sentence.split(" ");
        String[] replacedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String replacement = word;
            for (String root : dictionary) {
                if (word.startsWith(root)) {
                    replacement = root;
                    break;
                }
            }
            replacedWords[i] = replacement;
        }

        // Join the replaced words with a space separator
        return String.join(" ", replacedWords);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dictionary words (comma separated):");
        String dictInput = scanner.nextLine();
        List<String> dictionary = Arrays.asList(dictInput.split(","));

        System.out.println("Enter the sentence:");
        String sentence = scanner.nextLine();

        // Creating an instance of ReplaceWords class
        Solution replaceWordsInstance = new Solution();
        String result = replaceWordsInstance.replaceWords(dictionary, sentence);

        System.out.println("Output sentence:");
        System.out.println(result);

        scanner.close();
    }
}