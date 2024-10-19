public class Solution {
    
    public char findKthBit(int n, int k) {
        // Base case: S1 = "0"
        if (n == 1) {
            return '0';
        }
        
        // Find the length of Sn, which is 2^n - 1
        int length = (1 << n) - 1; // This is 2^n - 1
        
        // Middle of the string is always the (length / 2 + 1)th bit and is '1'
        int mid = length / 2 + 1;
        
        if (k == mid) {
            return '1'; // Middle bit is always '1'
        } else if (k < mid) {
            // If k is in the first half, it's the same as the (k)th bit in Sn-1
            return findKthBit(n - 1, k);
        } else {
            // If k is in the second half, it's the inverse of the (length - k + 1)th bit in Sn-1
            return invert(findKthBit(n - 1, length - k + 1));
        }
    }
    
    // Helper function to invert a bit
    private char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.findKthBit(3, 1)); // Output: "0"
        System.out.println(solution.findKthBit(4, 11)); // Output: "1"
    }
}
