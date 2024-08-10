class Solution {
    public boolean isAnagram(String s, String t) {
        // Convert both strings to lowercase to make the comparison case-insensitive
        s = s.toLowerCase();
        t = t.toLowerCase();
        
        // Check if the lengths of the two strings are equal
        if(s.length() == t.length()) {
            // Create two arrays to store the frequency of each character in both strings
            int[] arr = new int[256];  // Array to count characters in string `s`
            int[] brr = new int[256];  // Array to count characters in string `t`
            
            // Loop through each character in the strings
            for(int i = 0; i < s.length(); i++) {
                // Convert each character to its ASCII value and increment the corresponding index in the arrays
                arr[(int) s.charAt(i)] += 1;
                brr[(int) t.charAt(i)] += 1;
            }
            
            // Compare the character counts in both arrays
            for(int i = 0; i < 256; i++) {
                // If there's a mismatch in the character counts, the strings are not anagrams
                if(arr[i] != brr[i]) {
                    return false;
                }
            }
            
            // If all character counts match, the strings are anagrams
            return true;
        } else {
            // If the lengths are not equal, they cannot be anagrams
            return false;
        }
    }
}
