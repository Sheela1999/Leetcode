import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Manually creating the tree based on the example input
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.print("Enter the number of nodes to delete: ");
        int deleteCount = scanner.nextInt();
        int[] to_delete = new int[deleteCount];
        
        System.out.println("Enter the values of nodes to delete: ");
        for (int i = 0; i < deleteCount; i++) {
            to_delete[i] = scanner.nextInt();
        }
        
        DeleteNodesAndReturnForest solver = new DeleteNodesAndReturnForest();
        List<TreeNode> result = solver.delNodes(root, to_delete);
        
        System.out.println("Remaining forest:");
        for (TreeNode tree : result) {
            printTree(tree);
            System.out.println();
        }
    }

    // Helper method to print the tree in a pre-order manner
    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        
        List<TreeNode> forest = new ArrayList<>();
        root = deleteNodes(root, toDeleteSet, forest);
        
        if (root != null) {
            forest.add(root);
        }
        
        return forest;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        
        node.left = deleteNodes(node.left, toDeleteSet, forest);
        node.right = deleteNodes(node.right, toDeleteSet, forest);
        
        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }
        
        return node;
    }
}
