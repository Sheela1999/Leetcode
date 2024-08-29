class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        
        for (int[] stone : stones) {
            // We use (stone[0], -(stone[1] + 1)) to differentiate between rows and columns
            // to prevent false connections between different rows and columns with the same index.
            uf.union(stone[0], ~(stone[1]));
        }
        
        // Count the number of distinct root nodes, which represents the number of connected components.
        return stones.length - uf.getCount();
    }
}

class UnionFind {
    private Map<Integer, Integer> parent;
    private int count;

    public UnionFind() {
        parent = new HashMap<>();
        count = 0;
    }

    public int find(int x) {
        if (parent.putIfAbsent(x, x) == null) {
            count++;
        }
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent.put(rootX, rootY);
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
