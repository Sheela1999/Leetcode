public class CountAndSay {

    // Function to return the nth term in the count-and-say sequence
    public static String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }

        // Recursively get the (n-1)th term
        String prevTerm = countAndSay(n - 1);
        StringBuilder currentTerm = new StringBuilder();

        // Process the (n-1)th term to generate the nth term
        int count = 1;
        for (int i = 1; i < prevTerm.length(); i++) {
            if (prevTerm.charAt(i) == prevTerm.charAt(i - 1)) {
                count++; // Count the same digit
            } else {
                currentTerm.append(count).append(prevTerm.charAt(i - 1)); // Append count and digit
                count = 1; // Reset count for the new digit
            }
        }
        // Append the last processed group
        currentTerm.append(count).append(prevTerm.charAt(prevTerm.length() - 1));

        return currentTerm.toString();
    }
}