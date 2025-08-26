import java.util.ArrayList;
import java.util.List;

public class PostOrder145E
{
    public static void main(String[] args)
    {
        Nodes1 root = new Nodes1(1);
        root.left = new Nodes1(2);
        root.right = new Nodes1(3);
        root.left.left = new Nodes1(4);
        root.left.right = new Nodes1(5);
        root.left.right.left = new Nodes1(6);
        root.right.left = new Nodes1(7);
        root.right.right = new Nodes1(8);
        root.right.right.left = new Nodes1(9);
        root.right.right.right = new Nodes1(10);
        List<Integer> ans = postorderTraversal(root);
        System.out.println(ans);

    }

    public static List<Integer> postorderTraversal(Nodes1 root)
    {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    public static void postOrder(Nodes1 root, List<Integer> arr)
    {
        if(root == null)
            return;
        postOrder(root.left, arr);
        postOrder(root.right, arr);
        arr.add(root.data);
    }
}

class Nodes1
{
    int data;
    Nodes1 left;
    Nodes1 right;
    public Nodes1(int val)
    {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
