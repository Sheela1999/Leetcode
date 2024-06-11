public class Solution{
	public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left to make space for the next bit
            result <<= 1;
            // Add the least significant bit of n to result
            result |= (n & 1);
            // Shift n right to process the next bit
            n >>= 1;
        }
        return result;
    }
	
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Solution sol = new Solution();
        int reversed = sol.reverseBits(num);
        System.out.println(reversed);
    }
}