public class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR the start and goal to find the bits that differ
        int xor = start ^ goal;
        
        // Count the number of set bits (1's) in the XOR result
        int bitFlips = 0;
        while (xor > 0) {
            bitFlips += xor & 1;  // Check if the least significant bit is 1
            xor >>= 1;            // Right shift to check the next bit
        }
        
        return bitFlips;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int start1 = 10;
        int goal1 = 7;
        System.out.println("Minimum bit flips (start: " + start1 + ", goal: " + goal1 + ") = " + solution.minBitFlips(start1, goal1)); // Output: 3

        // Test case 2
        int start2 = 3;
        int goal2 = 4;
        System.out.println("Minimum bit flips (start: " + start2 + ", goal: " + goal2 + ") = " + solution.minBitFlips(start2, goal2)); // Output: 3
    }
}
