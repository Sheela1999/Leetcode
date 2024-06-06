public class PalindromeChecker {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        // Convert the string to lower case and remove non-alphanumeric characters
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        // Use two pointers to check if the string is a palindrome
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.isPalindrome(s);
        System.out.println("Is the given string a palindrome? " + result);

        scanner.close();
    }
}

//using StringBuilder
