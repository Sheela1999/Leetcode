
mport java.util.Scanner;
public class Solution {

    public static void main(String[] args){
    
        Scanner scan= new Scanner(System.in);
        int inputNum =scan.nextInt();
        for(int k=0; k<inputNum; k++){
             nStarDiamond(inputNum);
             
        }
    }

    public static void nStarDiamond(int n) {
        for (int i = 0; i < n; i++){

        for (int j =0; j<n-i-1; j++)
        {
            System.out.print(" ");
        }
       
        for(int j=0;j< 2*i+1;j++){  
            System.out.print("*");
        }
        
         for (int j =0; j<n-i-1; j++){
            System.out.print(" ");
        }
         System.out.println();
    }

        for (int i = 0; i < n; i++){
        
        for (int j =0; j<i; j++){
            System.out.print(" ");
        }
       
        for(int j=0;j< 2*n -(2*i +1);j++){
            System.out.print("*");
        }
        
        for (int j =0; j<i; j++)
        {
            System.out.print(" ");
        }
       
        System.out.println();
     }
   }

}

Output:
    *
  * * *
  * * *
    *