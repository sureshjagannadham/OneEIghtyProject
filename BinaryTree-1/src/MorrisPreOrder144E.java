
import java.util.ArrayList;
import java.util.List;

public class MorrisPreOrder144E
{
    public static void main(String[] args)
    {
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);
        root.left.right.left = new Node2(6);
        root.right.left = new Node2(7);
        root.right.right = new Node2(8);
        root.right.right.left = new Node2(9);
        root.right.right.right = new Node2(10);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans);

    }
    public static List<Integer> inorderTraversal(Node2 root)
    {
        List<Integer> arr = new ArrayList<>();
        Node2 cur = root;
        while(cur != null)
        {
            if(cur.left == null)
            {
                arr.add(cur.data);
                cur = cur.right;
            }
            else
            {
                Node2 prev = cur.left;
                while(prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = cur;
                    arr.add(cur.data);
                    cur = cur.left;
                }
                else
                {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return arr;
    }
}
class Node2
{
    int data;
    Node2 left;
    Node2 right;
    public Node2(int val)
    {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

