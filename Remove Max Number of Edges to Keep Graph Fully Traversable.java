public class MaxEdgesToRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of nodes
        int n = scanner.nextInt();

        // Input number of edges
        int edgeCount = scanner.nextInt();
        int[][] edges = new int[edgeCount][3];

        // Input edges
        for (int i = 0; i < edgeCount; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }

        System.out.println(maxNumEdgesToRemove(n, edges));
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        // Union-Find for Alice and Bob separately
        UnionFind aliceUF = new UnionFind(n);
        UnionFind bobUF = new UnionFind(n);

        // Number of edges used by Alice and Bob
        int aliceEdges = 0;
        int bobEdges = 0;
        int commonEdges = 0;

        // Process type 3 edges first (common edges)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceConnected = aliceUF.union(edge[1] - 1, edge[2] - 1);
                boolean bobConnected = bobUF.union(edge[1] - 1, edge[2] - 1);
                if (aliceConnected || bobConnected) {
                    commonEdges++;
                }
            }
        }

        // Process type 1 edges (Alice only)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (aliceUF.union(edge[1] - 1, edge[2] - 1)) {
                    aliceEdges++;
                }
            }
        }

        // Process type 2 edges (Bob only)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bobUF.union(edge[1] - 1, edge[2] - 1)) {
                    bobEdges++;
                }
            }
        }

        // Check if both Alice and Bob can fully traverse the graph
        if (aliceUF.count != 1 || bobUF.count != 1) {
            return -1;
        }

        // Total edges used
        int totalUsedEdges = aliceEdges + bobEdges + commonEdges;

        // Maximum number of edges to remove
        return edges.length - totalUsedEdges;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);  // Path compression
            }
            return parent[p];
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return false;

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
            return true;
        }
    }
}