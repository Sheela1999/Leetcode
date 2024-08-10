class UnionFind {
    private int[] parent; // This array keeps track of the parent of each element.
    private int[] rank;   // This array helps to keep the tree flat by ranking elements.
    private int count;    // This keeps track of the number of distinct components (regions).

    public UnionFind(int size) {
        parent = new int[size];  // Initialize the parent array to hold each element's parent.
        rank = new int[size];    // Initialize the rank array.
        count = size;            // Initially, each element is its own component, so count = size.
        for (int i = 0; i < size; i++) {
            parent[i] = i;       // Initially, each element is its own parent.
            rank[i] = 1;         // Initial rank for each element is 1.
        }
    }

    public int find(int x) {
        if (parent[x] != x) {      // If x is not its own parent, then it's part of a union.
            parent[x] = find(parent[x]); // Path compression: make the parent of x its root.
        }
        return parent[x];          // Return the root of x.
    }

    public void union(int x, int y) {
        int rootX = find(x);  // Find the root of x.
        int rootY = find(y);  // Find the root of y.

        if (rootX != rootY) {   // If they are not already in the same component:
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;  // Union by rank: attach the smaller tree under the bigger one.
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;  // Union by rank: attach the smaller tree under the bigger one.
            } else {
                parent[rootY] = rootX;  // If the ranks are the same, make one the root and increment its rank.
                rank[rootX]++;
            }
            count--; // Since we've merged two components, reduce the component count.
        }
    }

    public int getCount() {
        return count; // Return the current number of distinct components.
    }
}
