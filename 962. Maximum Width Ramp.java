class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0; // Count of unmatched '('
        int closeNeeded = 0; // Count of unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If we encounter an opening bracket, we expect a closing one in the future.
                openNeeded++;
            } else {
                // If we encounter a closing bracket, we check if there is an unmatched opening bracket.
                if (openNeeded > 0) {
                    // If there are unmatched '(' brackets, this ')' balances one of them.
                    openNeeded--;
                } else {
                    // If no unmatched '(', this closing bracket is unbalanced.
                    closeNeeded++;
                }
            }
        }

        // The total moves needed are the number of unmatched opening and closing brackets.
        return openNeeded + closeNeeded;
    }
}
