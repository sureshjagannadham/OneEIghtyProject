import java.util.ArrayList;

public class DFSinGFG {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        // Initialize the adjacency list with empty lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph (0-based index):
        // Vertex 0 is connected to vertices 1 and 2
        // Vertex 1 is connected to vertices 0 and 3
        // Vertex 2 is connected to vertices 0 and 4
        // Vertex 3 is connected to vertex 1
        // Vertex 4 is connected to vertex 2
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(2);
        ArrayList<Integer> dfsResult = dfsOfGraph(adj);

        // Print the result
        System.out.println("Depth First Traversal starting from vertex 0:");
        System.out.println(dfsResult);
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visit = new boolean[V];
        visit[0] = true;
        dfs(0,visit, adj, dfs);
        return dfs;
    }

    public static void dfs(int node, boolean[] visit, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs)
    {
        visit[node] = true;
        dfs.add(node);
        for(Integer it: adj.get(node))
        {
            if(visit[it] == false)
                dfs(it, visit, adj, dfs);
        }
    }
}
