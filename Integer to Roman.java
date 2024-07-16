import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompting user to enter an integer
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        
        // Converting the integer to a Roman numeral
        String result = intToRoman(num);
        
        // Printing the result
        System.out.println("Roman numeral: " + result);
    }

    public static String intToRoman(int num) {
        // Arrays of Roman numerals and their corresponding integer values
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        // Building the Roman numeral from the highest to lowest decimal place
        return thousands[num / 1000] + 
               hundreds[(num % 1000) / 100] + 
               tens[(num % 100) / 10] + 
               ones[num % 10];
    }
}
