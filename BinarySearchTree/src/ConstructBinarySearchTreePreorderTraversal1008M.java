
// Definition for a binary tree node.
class TreeNodey {
    int val;
    TreeNodey left;
    TreeNodey right;

    TreeNodey(int x) {
        val = x;
    }
}

class ConstructBinarySearchTreePreorderTraversal1008M

{
    // Method to create a BST from preorder traversal
    public static TreeNodey bstFromPreorder(int[] preorder) {
        int bound = Integer.MAX_VALUE; // Maximum possible value for the node
        return helper(preorder, bound, new int[]{0}); // Start building the tree
    }

    // Recursive helper method
    private static TreeNodey helper(int[] nums, int bound, int[] i) {
        // Base case: If we reach the end of the array or the current value exceeds the bound
        if (i[0] == nums.length || nums[i[0]] > bound) {
            return null;
        }

        // Create the current node with the current preorder value
        TreeNodey root = new TreeNodey(nums[i[0]++]);

        // Build the left subtree with the current node's value as the new bound
        root.left = helper(nums, root.val, i);

        // Build the right subtree with the original bound
        root.right = helper(nums, bound, i);

        return root; // Return the constructed node
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNodey root = bstFromPreorder(preorder); // Calling the static method directly

        // Print the tree in preorder to verify it
        System.out.println("Preorder Traversal of the constructed BST:");
        printPreorder(root);
    }

    // Static helper method to print the tree in preorder for verification
    private static void printPreorder(TreeNodey node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Print the node value
        printPreorder(node.left); // Recur on left subtree
        printPreorder(node.right); // Recur on right subtree
    }
}