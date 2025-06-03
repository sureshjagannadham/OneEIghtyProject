public class BalancedBT110E
{
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(Node root)
    {
        return getBalanced(root) != -1;
    }
    public static int getBalanced(Node root)
    {
        if(root == null)
            return 0;
        int lh = getBalanced(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = getBalanced(root.right);
        if (rh == -1) {
            return -1;
        }
        if(Math.abs(lh - rh) >1)
            return -1;
        return Math.max(lh , rh) +1;
    }
}

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
