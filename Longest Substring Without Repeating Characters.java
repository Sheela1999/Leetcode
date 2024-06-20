public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        
        int result = lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        // HashMap to store the most recent index of each character
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        
        // Initialize pointers and the maximum length
        int left = 0;
        int maxLength = 0;
        
        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the map and within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // Move the left pointer to the right of the duplicate character's last index
                left = charIndexMap.get(currentChar) + 1;
            }
            
            // Update the most recent index of the current character
            charIndexMap.put(currentChar, right);
            
            // Calculate the length of the current window and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;  // Return the maximum length found
    }
}