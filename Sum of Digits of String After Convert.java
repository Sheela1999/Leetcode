class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to a number by replacing each letter with its position in the alphabet
        StringBuilder numberStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1;
            numberStr.append(value);
        }
        
        // Step 2: Perform the transformation operation k times
        String result = numberStr.toString();
        for (int i = 0; i < k; i++) {
            result = sumOfDigits(result);
        }
        
        // Convert the final result to an integer and return it
        return Integer.parseInt(result);
    }
    
    // Helper function to calculate the sum of digits of a given string representation of a number
    private String sumOfDigits(String numberStr) {
        int sum = 0;
        for (char c : numberStr.toCharArray()) {
            sum += c - '0';
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "iiii";
        int k1 = 1;
        System.out.println(solution.getLucky(s1, k1)); // Output: 36

        // Test case 2
        String s2 = "leetcode";
        int k2 = 2;
        System.out.println(solution.getLucky(s2, k2)); // Output: 6

        // Test case 3
        String s3 = "zbax";
        int k3 = 2;
        System.out.println(solution.getLucky(s3, k3)); // Output: 8
    }
}
