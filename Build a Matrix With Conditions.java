import java.util.*;

public class MatrixBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input k
        System.out.print("Enter value of k: ");
        int k = scanner.nextInt();

        // Input rowConditions
        System.out.print("Enter number of row conditions: ");
        int n = scanner.nextInt();
        int[][] rowConditions = new int[n][2];
        System.out.println("Enter row conditions (format: above below):");
        for (int i = 0; i < n; i++) {
            rowConditions[i][0] = scanner.nextInt();
            rowConditions[i][1] = scanner.nextInt();
        }

        // Input colConditions
        System.out.print("Enter number of column conditions: ");
        int m = scanner.nextInt();
        int[][] colConditions = new int[m][2];
        System.out.println("Enter column conditions (format: left right):");
        for (int i = 0; i < m; i++) {
            colConditions[i][0] = scanner.nextInt();
            colConditions[i][1] = scanner.nextInt();
        }

        int[][] result = buildMatrix(k, rowConditions, colConditions);

        // Output the result
        System.out.println("Output matrix:");
        if (result.length == 0) {
            System.out.println("[]");
        } else {
            for (int[] row : result) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Get the row and column orders
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);

        // If any order is empty, return empty matrix (cycle detected)
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }

        // Create the matrix and position maps
        int[][] matrix = new int[k][k];
        Map<Integer, Integer> rowPosition = new HashMap<>();
        Map<Integer, Integer> colPosition = new HashMap<>();

        // Fill the row and column positions
        for (int i = 0; i < k; i++) {
            rowPosition.put(rowOrder.get(i), i);
            colPosition.put(colOrder.get(i), i);
        }

        // Place the numbers in the matrix
        for (int num = 1; num <= k; num++) {
            int row = rowPosition.get(num);
            int col = colPosition.get(num);
            matrix[row][col] = num;
        }

        return matrix;
    }

    public static List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[k + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build the graph and in-degree count
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }

        // Initialize the queue with nodes having zero in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform the topological sort
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // Check for a cycle (if all nodes are not processed)
        if (result.size() != k) {
            return new ArrayList<>();
        }

        return result;
    }
}
