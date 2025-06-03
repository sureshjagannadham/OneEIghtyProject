import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraphByBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 6;  // Number of vertices

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding directed edges to the adjacency list
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Check for cycles
        if (isCycle(n, adj)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indeg = new int[V];

        // Step 1: Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indeg[it]++;
            }
        }

        // Step 2: Initialize queue with all vertices that have in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        int count = 0; // Count of visited nodes

        // Step 3: Process the graph using BFS
        while (!q.isEmpty()) {
            int node = q.poll(); // Dequeue a vertex from the queue
            count++; // Increment the visited node count

            // Decrease the in-degree of neighboring vertices
            for (int it : adj.get(node)) {
                indeg[it]--;
                // If in-degree becomes 0, add it to the queue
                if (indeg[it] == 0)
                    q.add(it);
            }
        }

        // If count of visited nodes is less than V, a cycle exists
        return count != V;
    }
}