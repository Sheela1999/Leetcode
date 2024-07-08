import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of friends
        System.out.print("Enter the number of friends (n): ");
        int n = scanner.nextInt();

        // Read the count number (k)
        System.out.print("Enter the count number (k): ");
        int k = scanner.nextInt();

        // Determine the winner
        int winner = findTheWinner(n, k);

        // Output the winner
        System.out.println("The winner is friend: " + winner);
    }

    private static int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int currentIndex = 0;

        // Simulate the game until only one friend is left
        while (friends.size() > 1) {
            currentIndex = (currentIndex + k - 1) % friends.size();
            friends.remove(currentIndex);
        }

        return friends.get(0);
    }
}
