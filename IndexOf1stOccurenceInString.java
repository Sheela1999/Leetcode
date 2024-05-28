import java.util.Scanner;

public class Solution {
	
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        if (needleLength > haystackLength) {
            return -1;
        }
        
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read haystack and needle from the user
        String haystack = scanner.nextLine();

        String needle = scanner.nextLine();

        Solution solution = new Solution();
        int result = solution.strStr(haystack, needle);
        
        System.out.println(result);
    }
}