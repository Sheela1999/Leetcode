Sample Input

2
0 2 10
5 3 5
Sample Output

2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98

solution:

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            generateSeries(a,b,n);
            
        }
        in.close();
    }
    private static void generateSeries(int a, int b, int n){
        int result = a;
        for(int i=0; i<n; i++){
            result += (Math.pow(2, i) * b);
            System.out.print(result + " ");
        }

        System.out.println();
    }
}