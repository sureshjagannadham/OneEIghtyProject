import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal103M
{
    public static void main(String[] args)
    {
        Node11 root = new Node11(1);
        root.left = new Node11(2);
        root.right = new Node11(3);
        root.left.left = new Node11(4);
        root.left.right = new Node11(5);
        root.right.left = new Node11(6);
        root.right.right = new Node11(7);
        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);
    }

    public static List<List<Integer>> zigzagLevelOrder(Node11 root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result; // Handle empty tree
        }
        Queue<Node11> q = new LinkedList<>();
        q.add(root);
        boolean LtoR = true; // means that 0
        while (!q.isEmpty())
        {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                Node11 node = q.poll();
                if (node != null) {
                    if (LtoR) {
                        row.add(node.data);  // Add from left to right
                    } else {
                        row.add(0, node.data); // Add to the beginning for right to left
                    }
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
            }
            LtoR = !LtoR;
            result.add(row);
        }
        return result;
    }
}
class Node11 {
    int data;
    Node11 left;
    Node11 right;

    // Constructor to initialize
    // the node with a value
    Node11(int val) {
        data = val;
        left = null;
        right = null;
    }
}
