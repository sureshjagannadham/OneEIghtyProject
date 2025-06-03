import java.util.ArrayList;

public class DetectCycleDirectedGraphByDFS
{
    public static void main(String[] args)
    {
        int v = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(3).add(7);
        adj.get(7).add(5);
        adj.get(5).add(6);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(8).add(2);

        boolean ans = isCycle(v, adj);
        if(ans)
            System.out.println("True");
        else
            System.out.println("False");

    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        for(int i=0; i<V; i++)
        {
            if(vis[i] == 0)
            {
                if(checkDFS(i, vis, pathVis, adj) == true)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkDFS(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it: adj.get(node))
        {
            if(vis[it] == 0)
            {
                if(checkDFS(it, vis, pathVis, adj) == true)
                    return true;
            }
            else if(pathVis[it] == 1)
                return true;
            pathVis[it] = 0;
        }
        return false;
    }
}
