import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorderTraversal105M
{
    public static void main(String[] args)
    {
        int[] inorder = {40,20,50,10,60,30};
        int[] preorder = {10,20,40,50,30,60};
        TreeNode root = buildTree(preorder, inorder);
        printTree(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        Map<Integer, Integer> inmap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            inmap.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0,inorder.length-1, inmap);
        return root;
    }

    private static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inmap)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inmap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper(preorder, preStart+1, preEnd+numsLeft,inorder,inStart,inRoot-1, inmap);
        root.right = helper(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inmap);
        return root;
    }
    public static void printTree(TreeNode root)
    {
        if(root != null)
        {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
;        }
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }
