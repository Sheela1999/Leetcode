public class IntegerComplement {

    public int findComplement(int num) {
        // Step 1: Find the bit length of the number
        int bitLength = Integer.toBinaryString(num).length();
        
        // Step 2: Create a mask with all bits set to 1, the same length as num
        int mask = (1 << bitLength) - 1;
        
        // Step 3: XOR the number with the mask to flip the bits
        return num ^ mask;
    }
}