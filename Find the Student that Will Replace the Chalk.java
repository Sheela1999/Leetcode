class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total sum of chalk usage in one full round
        long totalChalk = 0;
        for (int c : chalk) {
            totalChalk += c;
        }

        // Step 2: Reduce k by the total chalk used in full rounds
        k %= totalChalk;

        // Step 3: Find the student who will need to replace the chalk
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        // If the loop finishes without returning, it means the problem statement is not followed
        // However, the problem guarantees that the loop will always find a student
        return -1;
    }
}