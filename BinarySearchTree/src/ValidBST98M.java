class TreeNode {
    int val;
    TreeNodey left;
    TreeNodey right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public static boolean isValidBST(TreeNodey root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNodey root, long mini, long maxi) {
        if (root == null) {
            return true;  // An empty tree is a valid BST
        }

        if (root.val <= mini || root.val >= maxi) {
            return false;  // Invalid BST condition
        }

        return helper(root.left, mini, root.val) && helper(root.right, root.val, maxi);
    }

    public static void main(String[] args) {
        // Create the BST based on the provided example
        TreeNodey root = new TreeNodey(13);
        root.left = new TreeNodey(10);
        root.left.left = new TreeNodey(7);
        root.left.left.right = new TreeNodey(9);
        root.left.left.right.left = new TreeNodey(8);
        root.left.right = new TreeNodey(12);
        root.right = new TreeNodey(15);
        root.right.left = new TreeNodey(14);
        root.right.right = new TreeNodey(17);
        root.right.right.left = new TreeNodey(16);

        // Validate the BST
        boolean result = isValidBST(root);
        System.out.println(result); // Expected output: true
    }
}