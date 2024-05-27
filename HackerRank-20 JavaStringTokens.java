Sample Input

He is a very very good boy, isn't he?
Sample Output

10
He
is
a
very
very
good
boy
isn
t
he

SOLUTION:

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        String[] tokens=s.split("[^a-zA-Z]");
        int num = 0;
        
        for(int i=0; i<tokens.length; ++i){
            if(tokens[i].length()>0){
                num++;
            }
            
        }
        System.out.println(num);
        for(int i=0; i<tokens.length;++i){
            if(tokens[i].length()>0){
                System.out.println(tokens[i]);
            }

        }
        scan.close();
    }
}