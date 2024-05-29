public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        
        // Find the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // The length of the last word is the difference between the length of the string
        // and the position of the last space + 1
        return s.length() - lastSpaceIndex - 1;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s1)); // Output: 5
        System.out.println(lengthOfLastWord(s2)); // Output: 4
        System.out.println(lengthOfLastWord(s3)); // Output: 6
    }
}

System.out.println("_________________________________________________________________________________");

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        
        // Split the string by spaces
        String[] words = s.split(" ");
        
        // The last word is the last element in the array
        String lastWord = words[words.length - 1];
        
        // Return the length of the last word
        return lastWord.length();
    }
}

System.out.println("________________________________________________________________________________________");

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Step 1: Trim the string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Initialize a variable to keep track of the length of the last word
        int length = 0;
        
        // Step 3: Iterate backwards over the trimmed string to find the last word
        for (int i = s.length() - 1; i >= 0; i--) {
            // Step 4: Check if the current character is a space
            if (s.charAt(i) == ' ') {
                // Step 5: If we encounter a space after counting some characters, break out of the loop
                break;
            }
            // Step 6: Increment the length counter for each non-space character
            length++;
        }
        
        // Step 7: Return the length of the last word
        return length;
    }

    public static void main(String[] args) {
        // Step 8: Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Step 9: Prompt the user to enter a string
        System.out.println("Enter a string:");

        // Step 10: Read the entire line of input
        String input = scanner.nextLine();

        // Step 11: Call the lengthOfLastWord method with the input string and print the result
        System.out.println("The length of the last word is: " + lengthOfLastWord(input));

        // Step 12: Close the scanner to avoid resource leaks
        scanner.close();
    }
}