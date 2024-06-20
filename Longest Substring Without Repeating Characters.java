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

Example Walkthrough
Example 1: s = "abcabcbb"
Iteration 1: right = 0, currentChar = 'a'

Update charIndexMap: {'a' -> 0}
maxLength = 1
Iteration 2: right = 1, currentChar = 'b'

Update charIndexMap: {'a' -> 0, 'b' -> 1}
maxLength = 2
Iteration 3: right = 2, currentChar = 'c'

Update charIndexMap: {'a' -> 0, 'b' -> 1, 'c' -> 2}
maxLength = 3
Iteration 4: right = 3, currentChar = 'a'

Character 'a' is in the current window. Move left to 1
Update charIndexMap: {'a' -> 3, 'b' -> 1, 'c' -> 2}
maxLength remains 3
Iteration 5: right = 4, currentChar = 'b'

Character 'b' is in the current window. Move left to 2
Update charIndexMap: {'a' -> 3, 'b' -> 4, 'c' -> 2}
maxLength remains 3
Iteration 6: right = 5, currentChar = 'c'

Character 'c' is in the current window. Move left to 3
Update charIndexMap: {'a' -> 3, 'b' -> 4, 'c' -> 5}
maxLength remains 3
Iteration 7: right = 6, currentChar = 'b'

Character 'b' is in the current window. Move left to 5
Update charIndexMap: {'a' -> 3, 'b' -> 6, 'c' -> 5}
maxLength remains 3
Iteration 8: right = 7, currentChar = 'b'

Character 'b' is in the current window. Move left to 7
Update charIndexMap: {'a' -> 3, 'b' -> 7, 'c' -> 5}
maxLength remains 3
The result is 3, as the longest substring without repeating characters is "abc".

Example 2: s = "bbbbb"
Only one unique character, so the result is 1.
Example 3: s = "pwwkew"
The longest substring without repeating characters is "wke", and the result is 3.