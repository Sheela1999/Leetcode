import java.util.Scanner;
public class Solution {

     public static void main(String[] args){
    
        Scanner scan= new Scanner(System.in);
        int inputNum =scan.nextInt();
        for(int k=0; k<inputNum; k++){
             nStarTriangle(inputNum);
        }
           
}
    public static void nStarTriangle(int n) {
        for(int i=0; i<n; i++){
           //space
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            //star
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            //space
            for(int j=0; j<=n-i-1; j++){
                System.out.print(" ");
            }
           System.out.println();
        }
    }
}

Output:

     *   
   * * *  
  * * * *