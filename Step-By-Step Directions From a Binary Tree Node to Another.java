import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class ShortestPathInBinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Example input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
        // Creating the tree manually as per the example
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        
        System.out.print("Enter startValue: ");
        int startValue = scanner.nextInt();
        
        System.out.print("Enter destValue: ");
        int destValue = scanner.nextInt();
        
        ShortestPathInBinaryTree solver = new ShortestPathInBinaryTree();
        String result = solver.getDirections(root, startValue, destValue);
        
        System.out.println("Output: " + result);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Step 1: Find the lowest common ancestor (LCA) of startValue and destValue
        TreeNode lca = findLCA(root, startValue, destValue);
        
        // Step 2: Find the path from the LCA to the startValue and destValue
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);
        
        // Step 3: Convert the path to startValue to 'U' (go up to the LCA)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        
        // Step 4: Append the path to destValue
        result.append(pathToDest);
        
        return result.toString();
    }

    // Helper method to find the lowest common ancestor (LCA)
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // Helper method to find the path from root to the given value
    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        
        // Try to go left
        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        // Try to go right
        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}
