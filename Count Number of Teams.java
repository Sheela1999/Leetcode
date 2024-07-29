import java.util.Scanner;

public class Solution {

    public static int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        // Iterate through all possible triples (i, j, k)
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check if the current triple (i, j, k) forms an increasing or decreasing sequence
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) ||
                        (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of soldiers: ");
        int n = scanner.nextInt();
        int[] rating = new int[n];

        System.out.print("Enter the ratings of the soldiers: ");
        for (int i = 0; i < n; i++) {
            rating[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.numTeams(rating);
        System.out.println("Number of valid teams: " + result);

        scanner.close();
    }
}
