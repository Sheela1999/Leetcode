import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        // Sort the skill array to make it easier to find pairs with equal total skill
        Arrays.sort(skill);
        
        // Total number of teams
        int n = skill.length;
        
        // The total skill for each team (sum of first and last element, and so on)
        int targetSum = skill[0] + skill[n - 1];
        
        long totalChemistry = 0;
        
        // Form teams from the sorted array
        for (int i = 0; i < n / 2; i++) {
            int player1 = skill[i];
            int player2 = skill[n - i - 1];
            
            // Check if the current pair's total skill matches the target sum
            if (player1 + player2 != targetSum) {
                return -1; // No valid division
            }
            
            // Calculate chemistry and add to the total chemistry
            totalChemistry += (long) player1 * player2;
        }
        
        return totalChemistry;
    }
}
