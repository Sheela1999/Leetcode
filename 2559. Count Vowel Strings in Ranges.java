import java.util.*;

public class VowelQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for words array
        System.out.println("Enter the number of words:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        // Input for queries array
        System.out.println("Enter the number of queries:");
        int q = scanner.nextInt();

        int[][] queries = new int[q][2];
        System.out.println("Enter the queries (li ri):");
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }

        // Compute the result
        int[] result = vowelQuery(words, queries);

        // Output the result
        System.out.println("Results:");
        for (int res : result) {
            System.out.println(res);
        }

        scanner.close();
    }

    private static int[] vowelQuery(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixCount = new int[n + 1]; // To store prefix sums of valid strings

        // Define vowels
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Compute prefix sums based on the condition
        for (int i = 0; i < n; i++) {
            if (isVowelString(words[i], vowels)) {
                prefixCount[i + 1] = prefixCount[i] + 1;
            } else {
                prefixCount[i + 1] = prefixCount[i];
            }
        }

        // Process each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = prefixCount[ri + 1] - prefixCount[li];
        }

        return result;
    }

    private static boolean isVowelString(String word, Set<Character> vowels) {
        if (word.isEmpty()) return false;
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return vowels.contains(first) && vowels.contains(last);
    }
}
