import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalOrder987H
{
    public static void main(String[] args)
    {
        TreeNode1 root  = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(10);
        root.left.left.right = new TreeNode1(5);
        root.left.left.right.right = new TreeNode1(6);
        root.right.left = new TreeNode1(9);
        root.right.right = new TreeNode1(10);
        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);

    }

    public static List<List<Integer>> verticalTraversal(TreeNode1 root)
    {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0,0));
        while(!q.isEmpty())
        {
            Tuple tuple = q.poll();
            TreeNode1 node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if(!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);
            if(node.left != null)
                q.offer(new Tuple(node.left, x-1, y+1));
            if(node.right != null)
                q.offer(new Tuple(node.right, x+1, y+1));
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values())
        {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values())
            {
                while(!nodes.isEmpty())
                {
                    System.out.println(nodes.peek());
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }

}
class Tuple
{
    TreeNode1 node;
    int row;
    int col;

    public Tuple(TreeNode1 node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class TreeNode1
{
    int val;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(int val) {
        this.val = val;
    }

    public TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
