import java.util.Scanner;
public class Solution {

    public static void main(String[] args){
    
        Scanner scan= new Scanner(System.in);
        int inputNum =scan.nextInt();
        for(int k=0; k<inputNum; k++){
             nTriangle(inputNum);
        }
           
}
    public static void nTriangle(int n) {
        for(int i=1; i<=n; i++){
           
            for(int j=1; j<=i; j++){
                System.out.print(i + " ");
            }
           System.out.println();
        }
    }
}

OUTPUT:

1
2 2
3 3 3