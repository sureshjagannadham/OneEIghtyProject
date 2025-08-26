/*
import java.util.ArrayList;
import java.util.List;

public class InOrder94E
{
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans.toString());
            // or below
        //System.out.println(ans);
    }
    public static List<Integer> inorderTraversal(Node root)
    {
        List<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        return arr;
    }

    public static void inOrder(Node root, List<Integer> arr)
    {
        if(root == null)
            return;

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);

    }
}



class Node
{
    int data;
    Node left;
    Node right;
    public Node(int val)
    {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
