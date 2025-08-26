import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePostorderInorderTraversal106M
{
    public static void main(String[] args)
    {
        int[] inorder = {40,20,50,10,60,30};
        int[] postorder = {40,50,20,60,30,10};
        TreeNode1 root = buildTree1(inorder, postorder);
        printTree(root);
    }
    public static TreeNode1 buildTree1(int[] inorder, int[] postorder)
    {
        if(inorder == null || postorder== null || inorder.length != postorder.length)
            return null;
        Map<Integer, Integer> inmap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            inmap.put(inorder[i], i);
        }

        TreeNode1 root = helper1(inorder, 0,inorder.length-1, postorder, 0, postorder.length-1, inmap);
        return root;
    }
    private static TreeNode1 helper1(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,  Map<Integer, Integer> inmap)
    {
        if(postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode1 root = new TreeNode1(postorder[postEnd]);
        int inRoot = inmap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper1(inorder, inStart,inRoot-1, postorder,postStart,postStart+numsLeft-1,inmap);
        root.right = helper1(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1, inmap);
        return root;
    }
    public static void printTree(TreeNode1 root)
    {
        if(root != null)
        {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}

class TreeNode1
{
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
