public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Read the input string
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Find and print the longest palindromic substring
        String longestPalindrome = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }

    // Function to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Find the length of the palindrome centered at i (odd length)
            int len1 = expandAroundCenter(s, i, i);

            // Find the length of the palindrome centered between i and i+1 (even length)
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length from the two cases
            int len = Math.max(len1, len2);

            // Update the start and end indices of the longest palindrome found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center and find the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        // Expand as long as the characters at L and R are the same
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        // Return the length of the palindrome
        return R - L - 1;
    }
}
Explanation:
Main Method:

The main method reads the input string from the user using the Scanner class.
It then calls the longestPalindrome method to find the longest palindromic substring.
Finally, it prints the longest palindromic substring.
longestPalindrome Method:

This method finds the longest palindromic substring in the input string s.
It initializes two variables, start and end, to keep track of the start and end indices of the longest palindromic substring found.
It iterates through each character in the string and checks two cases for palindromes: odd-length (centered at a single character) and even-length (centered between two characters).
It calculates the lengths of the palindromes for both cases using the expandAroundCenter helper method.
It updates the start and end indices if a longer palindrome is found.
Finally, it returns the longest palindromic substring by taking the substring from start to end (inclusive).
expandAroundCenter Method:

This helper method expands around the center indices left and right to find the length of the palindrome.
It starts with L = left and R = right and expands outward as long as the characters at L and R are the same.
It returns the length of the palindrome found.
Example:
For the input string "babad":

The main method reads the input string and calls longestPalindrome("babad").
longestPalindrome iterates through each character:
For i = 0 ("b"), it finds a palindrome of length 1 ("b").
For i = 1 ("a"), it finds a palindrome of length 3 ("bab").
For i = 2 ("b"), it finds a palindrome of length 3 ("aba").
For i = 3 ("a"), it finds a palindrome of length 1 ("a").
For i = 4 ("d"), it finds a palindrome of length 1 ("d").
The longest palindrome found is "bab".
The main method prints the result: Longest Palindromic Substring: bab.
For the input string "cbbd":

The main method reads the input string and calls longestPalindrome("cbbd").
longestPalindrome iterates through each character:
For i = 0 ("c"), it finds a palindrome of length 1 ("c").
For i = 1 ("b"), it finds a palindrome of length 2 ("bb").
For i = 2 ("b"), it finds a palindrome of length 1 ("b").
For i = 3 ("d"), it finds a palindrome of length 1 ("d").
The longest palindrome found is "bb".
The main method prints the result: Longest Palindromic Substring: bb.