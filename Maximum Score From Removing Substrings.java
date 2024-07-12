import java.util.Scanner;
import java.util.Stack;

public class MaxPointsSubstring {

    public static int maximumPoints(String s, int x, int y) {
        // Determine which operation to prioritize based on the points
        if (x < y) {
            // If removing "ab" gains fewer points, swap x and y and reverse the logic
            return maximumPoints(new StringBuilder(s).reverse().toString(), y, x);
        }

        // First remove as many "ab" as possible since x >= y
        int points = 0;
        Stack<Character> stack = new Stack<>();

        // Process for "ab"
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                stack.pop(); // Remove "a" from stack, effectively removing "ab"
                points += x; // Add points for "ab"
            } else {
                stack.push(c); // Push the character to the stack
            }
        }

        // Now process the remaining string for "ba"
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.append(stack.pop());
        }
        remaining.reverse();

        // Process for "ba"
        for (char c : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop(); // Remove "b" from stack, effectively removing "ba"
                points += y; // Add points for "ba"
            } else {
                stack.push(c); // Push the character to the stack
            }
        }

        return points; // Return the total points collected
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input string
        System.out.println("Enter the string s:");
        String s = scanner.nextLine();

        // Read the points for removing "ab"
        System.out.println("Enter the points for removing 'ab':");
        int x = scanner.nextInt();

        // Read the points for removing "ba"
        System.out.println("Enter the points for removing 'ba':");
        int y = scanner.nextInt();

        // Calculate and print the maximum points
        int result = maximumPoints(s, x, y);
        System.out.println("Maximum points: " + result);
    }
}
