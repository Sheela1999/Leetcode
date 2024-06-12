import java.util.Scanner;

public class HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1; // Add 1 to count if the least significant bit is 1
            n >>>= 1;       // Unsigned right shift by 1
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int result = hammingWeight(n);
        
        System.out.println(result);
    }
}

Example
Consider the input number: n = 11.

Binary Representation:

11 in binary is 1011.
Step-by-step Execution:

Initialize count = 0.
n = 11, binary: 1011
n & 1 = 1 (last bit is 1), increment count to 1.
Right shift n by 1: n = 5, binary: 101.
n = 5, binary: 101
n & 1 = 1 (last bit is 1), increment count to 2.
Right shift n by 1: n = 2, binary: 10.
n = 2, binary: 10
n & 1 = 0 (last bit is 0), count remains 2.
Right shift n by 1: n = 1, binary: 1.
n = 1, binary: 1
n & 1 = 1 (last bit is 1), increment count to 3.
Right shift n by 1: n = 0.
Final count: 3.

Thus, the number of set bits in the binary representation of 11 is 3.