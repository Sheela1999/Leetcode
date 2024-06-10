import java.util.Scanner;

public class ExcelColumnTitle {
    public static String convertToTitle(int columnNumber) {
        String columnTitle = "";
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based indexing
            int remainder = columnNumber % 26;
            char currentChar = (char) ('A' + remainder);
            columnTitle = currentChar + columnTitle; // Prepend the character
            columnNumber /= 26;
        }
        
        return columnTitle;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the column number: ");
        int columnNumber = scanner.nextInt();
        
        String columnTitle = convertToTitle(columnNumber);
        System.out.println("The corresponding column title is: " + columnTitle);
        
        scanner.close();
    }
}


public class ExcelColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder columnTitle = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based indexing
            int remainder = columnNumber % 26;
            char currentChar = (char) ('A' + remainder);
            columnTitle.append(currentChar);
            columnNumber /= 26;
        }
        
        return columnTitle.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the column number: ");
        int columnNumber = scanner.nextInt();
        
        String columnTitle = convertToTitle(columnNumber);
        System.out.println("The corresponding column title is: " + columnTitle);
        
        scanner.close();
    }
}