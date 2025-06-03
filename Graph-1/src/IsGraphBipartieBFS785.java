
import java.util.LinkedList;
import java.util.Queue;

class IsGraphBipartieBFS785 {
    public static boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1; // -1 means uncolored
        }

        // Check for each node if it's not colored yet
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBFS(i, color, graph)) {
                    return false; // If a component is not bipartite, return false
                }
            }
        }

        return true; // All components are bipartite
    }

    public static  boolean checkBFS(int start, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; // Start coloring with color 0

        while (!q.isEmpty()) {
            int node = q.poll(); // Get the front of the queue

            // Check adjacent vertices
            for (int it : graph[node]) {
                if (color[it] == -1) { // If the node has not been colored yet
                    color[it] = 1 - color[node]; // Color with alternate color
                    q.add(it); // Add to the queue for exploration
                } else if (color[it] == color[node]) { // Same color as current node
                    return false; // Not bipartite
                }
            }
        }

        return true; // Successfully colored this component
    }

    public static void main(String[] args) {
        // Static input for the graph
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        boolean result = isBipartite(graph);

        if (result) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}