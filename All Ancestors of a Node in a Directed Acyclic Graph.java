public class DAGAncestors {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create an adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // Perform topological sort using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<TreeSet<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new TreeSet<>());
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Convert TreeSet to List for the final answer
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>(ancestors.get(i)));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading number of nodes
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        // Reading edges
        System.out.print("Enter number of edges: ");
        int e = scanner.nextInt();
        int[][] edges = new int[e][2];
        System.out.println("Enter edges (from to):");
        for (int i = 0; i < e; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        // Get ancestors
        List<List<Integer>> ancestors = getAncestors(n, edges);

        // Print the ancestors list
        for (int i = 0; i < ancestors.size(); i++) {
            System.out.println("Ancestors of node " + i + ": " + ancestors.get(i));
        }

        scanner.close();
    }
}