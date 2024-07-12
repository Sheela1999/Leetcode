import java.util.Stack;

public class ReverseParentheses {

    public static String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Push the current StringBuilder onto the stack and start a new one
                stack.push(current);
                current = new StringBuilder();
            } else if (ch == ')') {
                // Reverse the current StringBuilder
                current.reverse();
                // Pop from the stack and append the reversed string to it
                current = stack.pop().append(current);
            } else {
                // Append the character to the current StringBuilder
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "(abcd)";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + reverseParentheses(s1));

        // Example 2
        String s2 = "(u(love)i)";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + reverseParentheses(s2));

        // Example 3
        String s3 = "(ed(et(oc))el)";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + reverseParentheses(s3));
    }
}
