public class Solution {

    public String shortestPalindrome(String s) {
        // Find the longest palindrome starting from index 0
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        int[] lps = computeLPS(combined); // Compute the LPS array for the combined string
        
        // The value at the last index of the LPS array gives us the longest palindrome starting from 0
        int longestPalindromeLength = lps[lps.length - 1];

        // Add the non-palindromic part of the string at the start to make it a palindrome
        return reversed.substring(0, s.length() - longestPalindromeLength) + s;
    }

    private int[] computeLPS(String str) {
        int[] lps = new int[str.length()];
        int length = 0;
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}