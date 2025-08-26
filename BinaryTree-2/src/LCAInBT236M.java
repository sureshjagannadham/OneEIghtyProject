import java.util.Arrays;

public class LCAInBT236M
{
    public static void main(String[] args)
    {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.right.left = new TreeNode1(4);
        root.right.left.left = new TreeNode1(8);
        root.right.right = new TreeNode1(5);
        root.right.right.left = new TreeNode1(6);
        root.right.right.right = new TreeNode1(7);
        TreeNode1  ans= lowestCommonAncestor(root, root.right.right.right,root.right.left.left);
        System.out.println(ans.data);
    }

    public static TreeNode1 lowestCommonAncestor(TreeNode1 root, TreeNode1 p, TreeNode1 q)
    {
        if(root == null || root == p || root == q)
            return root;
        TreeNode1 lft = lowestCommonAncestor(root.left, p, q);
        TreeNode1 rht = lowestCommonAncestor(root.right, p, q);

        // get the result

        if(lft == null)
            return rht;
        else if(rht == null)
            return lft;
        // if both conditions are false then we got the result i.e., root
        else
            return root;
    }
}
class TreeNode1
{
    int data;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(int data) {
        this.data = data;
    }

    public TreeNode1(int data, TreeNode1 left, TreeNode1 right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
