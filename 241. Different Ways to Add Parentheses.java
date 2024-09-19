public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        // If the expression is purely a number, return it as the only result
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                // Divide expression into two parts and recursively solve
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // Combine the results from the left and right expressions
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') {
                            result.add(l + r);
                        } else if (ch == '-') {
                            result.add(l - r);
                        } else if (ch == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        // If the result is still empty, it means the input was a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}