import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFSInGFG
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

        ArrayList<Integer> all = topoSort(n, adj);
        System.out.print(all);
    }
    public static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++)
        {
            if(vis[i] == 0)
            {
                dfs(i, st, vis, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(V);
        int i=0;
        while(!st.isEmpty())
        {
            ans.add(st.pop());

        }
        return ans;
    }

    public static void dfs(int node, Stack<Integer> st, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(int it: adj.get(node))
        {
            if(vis[it] == 0)
            {
                dfs(it, st, vis, adj);
            }
        }
        st.push(node);
    }
}
