class Solution {
    public int minSwaps(String s) {
        int imbalance = 0; // This keeps track of unbalanced closing brackets.
        int maxImbalance = 0; // This tracks the maximum imbalance encountered.
        
        // Traverse the string to calculate the imbalance.
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // An opening bracket reduces imbalance (closes a closing bracket).
                imbalance--;
            } else {
                // A closing bracket increases imbalance (unbalanced closing).
                imbalance++;
            }
            // Keep track of the maximum imbalance (worst-case unbalanced closing brackets).
            maxImbalance = Math.max(maxImbalance, imbalance);
        }
        
        // The number of swaps required is the ceiling of maxImbalance / 2
        // Since each swap fixes two unbalanced brackets.
        return (maxImbalance + 1) / 2;
    }
}
