import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of pairs
        System.out.print("Enter the number of pairs of parentheses: ");
        int n = scanner.nextInt();

        // Generate and print all combinations of well-formed parentheses
        List<String> result = generateParentheses(n);
        System.out.println("All combinations of well-formed parentheses:");
        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }

    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // If the current string has reached the maximum length, add it to the result list
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // If we can add an open parenthesis, do so and recurse
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);  // Backtrack
        }

        // If we can add a close parenthesis, do so and recurse
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);  // Backtrack
        }
    }
}
