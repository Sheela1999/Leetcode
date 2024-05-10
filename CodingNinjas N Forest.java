public class Solution {

    public static void main(String[] args){
    
        Scanner scan= new Scanner(System.in);
        int inputNum =scan.nextInt();
        for(int k=0; k<inputNum; k++){
             nForest(inputNum);
        }
           
       }
       
    public static void nForest(int n) {
    
        for(int i=0; i<n; i++){
           
            for(int j=0; j<n; j++){
                System.out.print("* ");
            }
           System.out.println( );
        }
    }
} 

output:
* * *
* * *
* * *