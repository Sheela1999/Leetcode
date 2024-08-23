public class FractionCalculator {

    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        
        int i = 0;
        while (i < expression.length()) {
            // Determine the sign of the fraction
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = (expression.charAt(i) == '-') ? -1 : 1;
                i++;
            }
            
            // Parse the numerator
            int num = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Skip the slash character '/'
            i++;
            
            // Parse the denominator
            int den = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                den = den * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Apply the sign to the numerator
            num *= sign;
            
            // Add the fraction to the current result
            numerator = numerator * den + num * denominator;
            denominator *= den;
            
            // Reduce the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }

    // Helper function to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
}
}