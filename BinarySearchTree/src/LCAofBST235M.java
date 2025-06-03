// Definition for a binary tree node
class TreeNode12 {
    int val;
    TreeNode12 left;
    TreeNode12 right;

    TreeNode12(int val) {
        this.val = val;
    }
}

public class LCAofBST235M {

    // Static method to find the Lowest Common Ancestor of two nodes
    public static TreeNode12 lowestCommonAncestor(TreeNode12 root, TreeNode12 p, TreeNode12 q) {
        if (root == null) {
            return null;
        }

        int cur = root.val;

        // If both p and q are smaller than root, LCA lies in left subtree
        if (cur < p.val && cur < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If both p and q are greater than root, LCA lies in right subtree
        else if (cur > p.val && cur > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // We have found the split point, i.e., the LCA
        else {
            return root;
        }
    }

    // Static main method to run the example
    public static void main(String[] args) {
        // Create the binary search tree in a concise manner
        TreeNode12 root = new TreeNode12(13);
        root.left = new TreeNode12(10);
        root.left.left = new TreeNode12(7);
        root.left.left.right = new TreeNode12(9);
        root.left.left.right.left = new TreeNode12(8);
        root.left.right = new TreeNode12(12);
        root.right = new TreeNode12(15);
        root.right.left = new TreeNode12(14);
        root.right.right = new TreeNode12(17);
        root.right.right.left = new TreeNode12(16);

        // Define nodes for which we want to find the LCA
        TreeNode12 p = root.left.left; // Node with value 7
        TreeNode12 q = root.left.right; // Node with value 12

        // Find LCA
        TreeNode12 lca = lowestCommonAncestor(root, p, q);

        // Print the result
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));
    }
}