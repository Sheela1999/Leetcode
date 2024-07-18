import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class GoodLeafNodePairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the tree nodes in level order (use 'null' for null nodes):");
        String input = sc.nextLine();
        System.out.println("Enter the distance:");
        int distance = sc.nextInt();
        
        String[] nodes = input.split(",");
        TreeNode root = buildTree(nodes);
        
        int result = countGoodLeafPairs(root, distance);
        System.out.println("Number of good leaf node pairs: " + result);
    }

    // Method to build tree from level order input
    private static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            
            if (!nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.left);
            }
            i++;
            
            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }

    // Method to count good leaf pairs
    private static int countGoodLeafPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private static List<Integer> dfs(TreeNode node, int distance, int[] result) {
        List<Integer> distances = new ArrayList<>();
        
        if (node == null) return distances;
        
        if (node.left == null && node.right == null) {
            distances.add(1);
            return distances;
        }
        
        List<Integer> leftDistances = dfs(node.left, distance, result);
        List<Integer> rightDistances = dfs(node.right, distance, result);
        
        for (int lDist : leftDistances) {
            for (int rDist : rightDistances) {
                if (lDist + rDist <= distance) {
                    result[0]++;
                }
            }
        }
        
        for (int lDist : leftDistances) {
            if (lDist + 1 <= distance) {
                distances.add(lDist + 1);
            }
        }
        
        for (int rDist : rightDistances) {
            if (rDist + 1 <= distance) {
                distances.add(rDist + 1);
            }
        }
        
        return distances;
    }
}
