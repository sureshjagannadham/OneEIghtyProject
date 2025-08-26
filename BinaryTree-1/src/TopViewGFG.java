import java.util.*;

public class TopViewGFG
{
    public static void main(String[] args)
    {
        Nod root = new Nod(1);
        root.left = new Nod(2);
        root.right = new Nod(3);
        root.left.left = new Nod(4);
        root.left.right = new Nod(5);
        root.left.right.left = new Nod(6);
        root.right.right = new Nod(7);

        ArrayList<Integer> ans = topView(root);
        System.out.println(ans);
    }
    static ArrayList<Integer> topView(Nod root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<AbstractMap.SimpleEntry<Nod, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));
        while(!q.isEmpty())
        {
            AbstractMap.SimpleEntry<Nod, Integer> pair = q.poll();
            Nod node = pair.getKey();
            int line = pair.getValue();

            if(!mpp.containsKey(line))
                mpp.put(line, node.data);
            if(node.left != null)
                q.add(new AbstractMap.SimpleEntry<>(node.left, line-1));
            if(node.right != null)
                q.add(new AbstractMap.SimpleEntry<>(node.right, line+1));
        }

        for(int value: mpp.values())
            ans.add(value);
        return ans;
    }
}
class Nod
{
    int data;
    Nod left;
    Nod right;

    public Nod(int data) {
        this.data = data;
    }

    public Nod(int data, Nod left, Nod right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
