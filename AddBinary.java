class Solution {
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0){
            int sum = carry;

            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0) result.append(carry);

        return result.reverse().toString();
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        Solution sol = new Solution();
        String result = sol.addBinary(str1, str2);

        System.out.println(result);

        scan.close();
    }
}

System.out.println("-------------------------------------------------")

public class BinaryAddition {
    public static String addBinary(String a, String b) {
        String result = "";
        int carry = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result = (sum % 2) + result;
            carry = sum / 2;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first binary number: ");
        String a = scanner.next();

        System.out.print("Enter the second binary number: ");
        String b = scanner.next();

        System.out.println("Input: a = \"" + a + "\", b = \"" + b + "\"");
        System.out.println("Output: \"" + addBinary(a, b) + "\"");

        scanner.close();
    }
}