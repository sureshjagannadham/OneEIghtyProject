import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBT662M
{
    public static void main(String[] args)
    {
        Nodi root = new Nodi(3);
        root.left = new Nodi(5);
        root.right = new Nodi(1);
        root.left.left = new Nodi(6);
        root.left.right = new Nodi(2);
        root.right.left = new Nodi(0);
        root.right.right = new Nodi(8);
        root.left.right.left = new Nodi(7);
        root.left.right.right = new Nodi(4);
        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }

    public static int widthOfBinaryTree(Nodi root)
    {
        Queue<AbstractMap.SimpleEntry <Nodi, Integer>> q = new LinkedList<>();
        int ans = 0;
        q.offer(new AbstractMap.SimpleEntry<>(root, 0));
        while(!q.isEmpty())
        {
            int size = q.size();
            int index = q.peek().getValue();
            int first = 0;
            int last = 0;

            for(int i=0; i<size; i++)
            {
                int cur = q.peek().getValue()-index;
                Nodi node = q.peek().getKey();
                q.poll();
                if(i==0)
                    first = cur;
                if(i == size-1)
                    last = cur;
                if(node.left != null)
                    q.offer(new AbstractMap.SimpleEntry<>(node.left, 2 *cur +1));
                if(node.right != null)
                    q.offer(new AbstractMap.SimpleEntry<>(node.right, 2 *cur +2));
            }
            ans = Math.max(ans, last-first +1);
        }
        return ans;
    }
}
class Nodi
{
    int data;
    Nodi left;
    Nodi right;

    public Nodi(int data) {
        this.data = data;
    }

    public Nodi(int data, Nodi left, Nodi right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
