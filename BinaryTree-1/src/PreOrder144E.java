import java.util.ArrayList;
import java.util.List;

public class PreOrder144E
{
    public static void main(String[] args)
    {
        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        root.left.left = new Nodes(4);
        root.left.right = new Nodes(5);
        root.left.right.left = new Nodes(6);
        root.right.left = new Nodes(7);
        root.right.right = new Nodes(8);
        root.right.right.left = new Nodes(9);
        root.right.right.right = new Nodes(10);
        List<Integer> ans = preorderTraversal(root);
        System.out.println(ans);


    }
    public static List<Integer> preorderTraversal(Nodes root)
    {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }
    public static void preOrder(Nodes root, List<Integer> arr)
    {
        if(root == null)
            return;
        arr.add(root.data);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }
}
class Nodes
{
    int data;
    Nodes left;
    Nodes right;
    public Nodes(int val)
    {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
