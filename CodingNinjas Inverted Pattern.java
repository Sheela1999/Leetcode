import java.util.Scanner;
public class Solution {

    public static void main(String[] args){
    
        Scanner scan= new Scanner(System.in);
        int inputNum =scan.nextInt();
        for(int k=0; k<inputNum; k++){
             seeding(inputNum);
        }
           
}

    public static void seeding(int n) {
        for(int i=0; i<=n; i++){
           
            for(int j=n; j>i; j--){
                System.out.print("* ");
            }
           System.out.println();
        }
    }
}

Output:

* * *
* *
*