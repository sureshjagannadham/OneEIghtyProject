/*
public class ConvertSortedArraytoBST108E {
    public static void main(String[] args) {
        // Example test case
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNodex root = sortedArrayToBST(nums);

        // Printing the BST using in-order traversal
        System.out.println("In-order traversal of the BST:");
        inorderTraversal(root);
    }*/
/**//*


    // This function will convert a sorted array into a balanced BST
    public static TreeNodex sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return getBst(nums, 0, nums.length - 1);
    }

    // This helper function recursively creates a BST from the sorted array
    public static TreeNodex getBst(int[] nums, int start, int end) {
        if (start > end)
            return null;

        // Find the middle element and make it the root
        int mid = (start + end) / 2;
        TreeNodex bst = new TreeNodex(nums[mid]); // Use nums[mid] as the value

        // Recursively build the left and right subtrees
        bst.left = getBst(nums, start, mid - 1); // Left subtree
        bst.right = getBst(nums, mid + 1, end);  // Right subtree

        return bst;
    }

    // In-order traversal to print the tree nodes in sorted order
    public static void inorderTraversal(TreeNodex root) {
        if (root == null)
            return;

        // Traverse the left subtree
        inorderTraversal(root.left);

        // Print the current node's value
        System.out.print(root.val + " ");

        // Traverse the right subtree
        inorderTraversal(root.right);
    }
}

// TreeNode class to represent each node in the tree
class TreeNodex{
    int val;
    TreeNodey left;
    TreeNodey right;

    public TreeNodex(int val) {
        this.val = val;
    }

    public TreeNodex(int val, TreeNodey left, TreeNodey right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/
