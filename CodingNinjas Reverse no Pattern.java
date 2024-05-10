import java.util.Scanner;
public class Solution {

     public static void main(String[] args){
    
        Scanner scan= new Scanner(System.in);
        int inputNum =scan.nextInt();
        for(int k=0; k<inputNum; k++){
             nNumberTriangle(inputNum);
        }
           
}
    public static void nNumberTriangle(int n) {
        
        for(int i=1; i<=n; i++){
           
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j+" ");
            }
           System.out.println();
        }
    }
}

Output:

1 2 3
1 2
1