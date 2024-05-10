Sample Test case 0
Input (stdin)
hello
java
Your Output (stdout)
9
No
Hello Java
Expected Output
9
No
Hello Java
BlogScoringEnvironment

solution:

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        int sumLengths = A.length() + B.length();
        System.out.println(sumLengths);
        
        String comparisonResult = A.compareTo(B) > 0 ? "Yes" : "No";
        System.out.println(comparisonResult);
        
        String capitalizedStr1 = capitalizeFirstLetter(A);
        String capitalizedStr2 = capitalizeFirstLetter(B);
        System.out.println(capitalizedStr1 + " " + capitalizedStr2);

        sc.close();
        
    }
     private static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}