import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedByBFS
{
    public static void main(String[] args)
    {
        int v = 8; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        // Building the adjacency list
        adj.get(1).add(2);
        adj.get(2).add(1); // Undirected: add back edge
        adj.get(1).add(3);
        adj.get(3).add(1); // Undirected: add back edge
        adj.get(3).add(4);
        adj.get(4).add(3); // Undirected: add back edge
        adj.get(3).add(6);
        adj.get(6).add(3); // Undirected: add back edge
        adj.get(2).add(5);
        adj.get(5).add(2); // Undirected: add back edge
        adj.get(5).add(7);
        adj.get(7).add(5); // Undirected: add back edge
        adj.get(6).add(7);
        adj.get(7).add(6); // Undirected: add back edge

        boolean ans = isCycle(v, adj);
        if(ans)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static boolean isCycle(int V, ArrayList<ArrayList <Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!vis[i]) // If not already visited
            {
                if(isBFS(i, vis, adj)) // Check for cycle
                    return true;
            }
        }
        return false; // No cycle found
    }

    public static boolean isBFS(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Pair> q = new LinkedList<>();
        vis[node] = true; // Mark the node as visited
        q.add(new Pair(node, -1)); // Pair(node, parent)

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int currentNode = p.first;
            int parent = p.second;

            for(int it : adj.get(currentNode))
            {
                if(!vis[it]) // If the node is not visited
                {
                    vis[it] = true;
                    q.add(new Pair(it, currentNode)); // Add new node with currentNode as parent
                }
                // If visited and is not the parent, then there is a cycle
                else if(it != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found on this path
    }

    static class Pair
    {
        int first; // Node
        int second; // Parent node
        public Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
}