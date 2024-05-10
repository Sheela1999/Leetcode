End-of-file

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int lineNumber = 0;
        while (scanner.hasNext()) {
            lineNumber++;
            String line = scanner.nextLine();
            System.out.println(lineNumber + " " + line);
        }

        scanner.close();
    }    
        
}