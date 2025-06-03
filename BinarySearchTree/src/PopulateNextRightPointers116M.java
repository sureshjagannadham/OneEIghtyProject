public class PopulateNextRightPointers116M
{
    public static void main(String[] args) {
        // Example to test the function
        // Constructing a perfect binary tree:
        NodeN root = new NodeN(1);
        root.left = new NodeN(2);
        root.right = new NodeN(3);
        root.left.left = new NodeN(4);
        root.left.right = new NodeN(5);
        root.right.left = new NodeN(6);
        root.right.right = new NodeN(7);

        // Connect the next pointers
        connect(root);

        // Output the tree with next pointers
        printTree(root);
    }

    public static NodeN connect(NodeN root) {
        if (root == null)
            return null;

        NodeN cur = root;
        while (cur.left != null) { // Traverse level by level
            NodeN next = cur.left;  // Start with the leftmost node of the current level

            while (cur != null) {  // Traverse through nodes of the current level
                cur.left.next = cur.right;  // Link the left child to the right child

                if (cur.next != null) {
                    cur.right.next = cur.next.left;  // Link the right child to the next left child
                } else {
                    cur.right.next = null;  // Last node at the level, set next to null
                }

                cur = cur.next;  // Move to the next node in the current level
            }

            cur = next;  // Move to the next level, starting with the leftmost node
        }

        return root;
    }

    // Helper function to print the tree with next pointers
    public static void printTree(NodeN root) {
        NodeN levelStart = root;
        while (levelStart != null) {
            NodeN cur = levelStart;
            while (cur != null) {

                System.out.print(cur.val + " -> ");
                cur = cur.next;
            }
            System.out.println("null");
            levelStart = levelStart.left;  // Move to the next level
        }
    }
}
 class NodeN {
    int val;
    NodeN left;
    NodeN right;
    NodeN next;

    NodeN() {}

    NodeN(int val) {
        this.val = val;
    }

    NodeN(int val, NodeN left, NodeN right, NodeN next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
