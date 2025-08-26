import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFSInGFG
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=6;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int[] top = topo(n, adj);
        for (int j=0;j< top.length;j++){
            System.out.print(top[j]+" ");
        }
        //System.out.print(all);
    }

    public static int[] topo(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indeg = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int it: adj.get(i))
            {
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indeg[i] == 0)
                q.add(i);
        }

        int[] top = new int[V];
        int i=0;
        while(!q.isEmpty())
        {
            int node =  q.peek();
            q.remove();
            top[i++] = node;

            for(int it: adj.get(node))
            {
                indeg[it]--;
                if(indeg[it] == 0)
                    q.add(it);
            }
        }
        return top;
    }

}
