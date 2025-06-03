
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneUtil(node, map);
    }

    private Node cloneUtil(Node node, Map<Node, Node> mp)
    {
        Node newNode = new Node(node.val);
        mp.put(node, newNode);
        // now I ma checking for neightbours
        for(Node neighbor: node.neighbors)
        {
            if(!mp.containsKey(neighbor))
            {
                // not cloned
                newNode.neighbors.add(cloneUtil(neighbor, mp));
            }
            else
            {
                newNode.neighbors.add(mp.get(neighbor));
            }
        }
        return newNode;
    }
}

public class CloneGraphDFS133{
    public static void main(String[] args) {
        // Static Input: Build the graph based on the adjacency list
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Define the edges based on the input [[2, 4], [1, 3], [2, 4], [1, 3]]
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Create an instance of the Solution and clone the graph
        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print the cloned graph's adjacency list
        printAdjacencyList(clonedGraph);
    }

    // Function to print the adjacency list of the cloned graph
    public static void printAdjacencyList(Node node) {
        if (node == null) return;

        HashMap<Node, Boolean> visited = new HashMap<>();
        List<Node> queue = new ArrayList<>();
        queue.add(node);
        visited.put(node, true);

        List<List<Integer>> output = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.remove(0);
            List<Integer> neighborsList = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                neighborsList.add(neighbor.val);
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
            output.add(neighborsList);
        }

        System.out.println("Output: " + output.toString());
    }
}
