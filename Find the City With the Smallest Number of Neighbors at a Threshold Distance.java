import java.util.*;

public class CityWithSmallestNumberOfNeighbors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of cities
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();

        // Input number of edges
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        // Input edges
        int[][] edges = new int[m][3];
        System.out.println("Enter the edges (from, to, weight):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }

        // Input distance threshold
        System.out.print("Enter the distance threshold: ");
        int distanceThreshold = scanner.nextInt();

        // Find and print the city with the smallest number of neighbors within the distance threshold
        int result = findTheCity(n, edges, distanceThreshold);
        System.out.println("The city with the smallest number of neighbors within the distance threshold is: " + result);

        scanner.close();
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize distance matrix
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Set the distance from a city to itself as 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Fill the distance matrix with the given edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        // Floyd-Warshall algorithm to find shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Determine the city with the smallest number of reachable cities within the distance threshold
        int minReachableCities = Integer.MAX_VALUE;
        int cityWithMinReachableCities = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            if (reachableCities <= minReachableCities) {
                if (reachableCities == minReachableCities) {
                    cityWithMinReachableCities = Math.max(cityWithMinReachableCities, i);
                } else {
                    minReachableCities = reachableCities;
                    cityWithMinReachableCities = i;
                }
            }
        }

        return cityWithMinReachableCities;
    }
}
