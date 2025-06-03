public class FlattenBT114M
{
    //private static TreeNodef prev = null;
    public static void main(String[] args)
    {
        TreeNodef root = new TreeNodef(1);
        root.left = new TreeNodef(2);
        root.right = new TreeNodef(3);
        root.left.left = new TreeNodef(4);
        root.left.right = new TreeNodef(5);
        root.left.right.right = new TreeNodef(6);
        root.right.right = new TreeNodef(7);
        root.right.left = new TreeNodef(8);

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        //flatten(root);
        flattenOptimal(root);
        System.out.print("Binary Tree After Flatten: ");
        printFlatten(root);
        System.out.println();
    }

    /*public static void flatten(TreeNodef root)
    {
        // Brute Force using recursion T.V = O(n) & S.C= O(n)
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }*/
    public static  void flattenOptimal(TreeNodef root)
    {
        TreeNodef cur = root;
        if(root == null)
            return;
        while(cur != null)
        {
            if(cur.left != null)
            {
                TreeNodef prev = cur.left;
                while(prev.right != null)
                {
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    public static void printPreorder(TreeNodef root)
    {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void printFlatten(TreeNodef root)
    {
        if(root == null)
            return;
        System.out.print(root.val + " ");
        printFlatten(root.right);
    }
}
class TreeNodef{
    int val;
    TreeNodef left;
    TreeNodef right;

    public TreeNodef(int x)
    {
        val = x;
        left = null;
        right = null;
    }
}