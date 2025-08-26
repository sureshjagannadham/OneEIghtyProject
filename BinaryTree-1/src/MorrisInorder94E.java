
import java.util.ArrayList;
import java.util.List;

public class MorrisInorder94E
{
    public static void main(String[] args)
    {
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.left.right.left = new Node1(6);
        root.right.left = new Node1(7);
        root.right.right = new Node1(8);
        root.right.right.left = new Node1(9);
        root.right.right.right = new Node1(10);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans);

    }
    public static List<Integer> inorderTraversal(Node1 root)
    {
        List<Integer> arr = new ArrayList<>();
        Node1 cur = root;
        while(cur != null)
        {
            if(cur.left == null)
            {
                arr.add(cur.data);
                cur = cur.right;
            }
            else
            {
                Node1 prev = cur.left;
                while(prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = cur;
                    cur = cur.left;
                }
                else
                {
                    prev.right = null;
                    arr.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return arr;
    }
}
class Node1
{
    int data;
    Node1 left;
    Node1 right;
    public Node1(int val)
    {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}


