import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BFSinGFG
{
    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)) {
                if(!visited[it]) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
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
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);
        ArrayList<Integer> bfsResult = bfsOfGraph(V, adj);

        // Print the result
        System.out.println("Breadth First Traversal starting from vertex 0:");
        System.out.println(bfsResult);
    }
}
