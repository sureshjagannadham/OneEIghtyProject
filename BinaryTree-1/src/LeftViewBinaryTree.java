import java.util.ArrayList;
import java.util.List;

public class LeftViewBinaryTree
{
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        List<Integer> ans = leftView(root);
        System.out.println(ans);
    }
    public static List<Integer> leftView(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        getleftView(root, 0, ans);
        return ans;
    }
    public static void getleftView(Node root, int level,List<Integer> ans )
    {
        if(root == null)
            return;
        if(level == ans.size())
            ans.add(root.val);
        getleftView(root.left, level+1, ans);
        getleftView(root.right, level+1, ans);
    }
}
class Node
{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left= null;
        this.right = null;
    }
}
