import java.util.*;

public class Solution {

    // Node class to represent each node and its associated probability
    private static class Node {
        int vertex;
        double probability;

        Node(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create a graph representation
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Node(v, prob));
            graph.get(v).add(new Node(u, prob));
        }

        // Priority queue to get the next node with the maximum probability
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.add(new Node(start, 1.0));

        // Probability array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.vertex;
            double currentProb = current.probability;

            if (currentNode == end) {
                return currentProb;
            }

            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.vertex;
                double nextProb = neighbor.probability * currentProb;

                if (nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = nextProb;
                    pq.add(new Node(nextNode, nextProb));
                }
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb1 = {0.5, 0.5, 0.2};
        int start1 = 0;
        int end1 = 2;
        System.out.println(solution.maxProbability(n1, edges1, succProb1, start1, end1)); // Output: 0.25000

        int n2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb2 = {0.5, 0.5, 0.3};
        int start2 = 0;
        int end2 = 2;
        System.out.println(solution.maxProbability(n2, edges2, succProb2, start2, end2)); // Output: 0.30000

        int n3 = 3;
        int[][] edges3 = {{0, 1}};
        double[] succProb3 = {0.5};
        int start3 = 0;
        int end3 = 2;
        System.out.println(solution.maxProbability(n3, edges3, succProb3, start3, end3)); // Output: 0.00000
    }
}
