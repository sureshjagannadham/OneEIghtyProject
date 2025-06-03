public class SearchInBST700E
{
    public static void main(String[] args)
    {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.left = new Node(13);

        int value = 13;
        System.out.println(searchBST(root, value));


    }
    public static boolean searchBST(Node root, int val)
    {
        while(root != null)
        {
            if(root.val == val)
                return true;
            root = val < root.val ? root.left: root.right;
        }

        return false;
    }

}
class Node
{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

