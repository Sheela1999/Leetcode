import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input digits string
        System.out.print("Enter the digits: ");
        String digits = scanner.nextLine();

        // Get the letter combinations
        List<String> combinations = letterCombinations(digits);

        // Print the resulting combinations
        System.out.println("Possible letter combinations: " + combinations);

        scanner.close();
    }

    // Method to generate letter combinations
    public static List<String> letterCombinations(String digits) {
        // Map to store the digit-to-letter mapping
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        List<String> combinations = new ArrayList<>();

        // If the input is empty, return an empty list
        if (digits.isEmpty()) {
            return combinations;
        }

        // Helper method to perform the backtracking
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());

        return combinations;
    }

    // Helper method to perform the backtracking
    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder path) {
        // Base case: if the current path length is equal to the digits length, add it to the result
        if (index == digits.length()) {
            combinations.add(path.toString());
            return;
        }

        // Get the letters that the current digit maps to
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        // Loop through each letter and perform backtracking
        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(combinations, phoneMap, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
