import java.util.ArrayList;

public class DetectCycleUndirectedByDFS
{
    public static void main(String[] args)
    {
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(3).add(4);
        adj.get(3).add(6);
        adj.get(2).add(5);
        adj.get(5).add(7);
        adj.get(6).add(7);
        boolean ans = isCycle(v, adj);
        if(ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        for(int i=0; i<V; i++)
        {
            if(vis[i] == 0)
            {
                if(isDFS(i, -1, vis, adj) == true)
                    return true;
            }
        }
        return false;
    }
    public static boolean isDFS(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(int it: adj.get(node))
        {
            if(vis[it] == 0)
            {
                if(isDFS(it, node, vis, adj) == true)
                    return true;
            }
            else if(it != parent)
                return true;
        }
        return false;
    }
}
