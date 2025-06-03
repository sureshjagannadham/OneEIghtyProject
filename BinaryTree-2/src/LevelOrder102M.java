import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrder102M
{
    public static void main(String[] args)
    {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);

    }
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> all = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return all;
        q.offer(root);
        while(!q.isEmpty())
        {
            int levelno = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0; i<levelno; i++)
            {
                if(q.peek().left != null)
                    q.offer(q.peek().left);
                if(q.peek().right != null)
                    q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            all.add(sublist);
        }
        return all;
    }
}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
