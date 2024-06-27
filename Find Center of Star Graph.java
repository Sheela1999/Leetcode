public class StarGraphCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of edges
        int n = scanner.nextInt();
        int[][] edges = new int[n][2];
        
        // Reading the edges
        for (int i = 0; i < n; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        // Finding the center of the star graph
        int center = findCenter(edges);
        System.out.println(center);
    }

    public static int findCenter(int[][] edges) {
        // In a star graph, the center node will appear in the first two edges
        // at least once. So we just need to compare the nodes in the first edge
        // with the nodes in the second edge.

        // If the first node of the first edge equals the first or second node of the second edge
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else { // Otherwise, the second node of the first edge is the center
            return edges[0][1];
        }
    }
}