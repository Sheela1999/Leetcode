public class MinOperations {
    
    public int minSteps(int n) {
        int steps = 0;
        int divisor = 2;
        
        while (n > 1) {
            while (n % divisor == 0) {
                steps += divisor;
                n /= divisor;
            }
            divisor++;
        }
        
        return steps;
    }
}