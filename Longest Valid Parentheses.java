public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input string
        System.out.print("Enter a string of parentheses: ");
        String s = scanner.nextLine();

        // Find the length of the longest valid parentheses substring
        int result = longestValidParentheses(s);

        // Print the result
        System.out.println("Length of the longest valid parentheses substring: " + result);

        scanner.close();
    }

    // Function to find the length of the longest valid parentheses substring
    public static int longestValidParentheses(String s) {
        // Stack to store indices of the parentheses
        Stack<Integer> stack = new Stack<>();
        // Initialize the base of the valid parentheses
        stack.push(-1);
        int maxLength = 0;

        // Iterate through the characters of the string
        for (int i = 0; i < s.length(); i++) {
            // If the character is '(', push its index onto the stack
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // Pop the top of the stack
                stack.pop();
                // If the stack is empty, push the current index as the new base
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}