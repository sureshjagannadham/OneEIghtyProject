import java.util.HashMap;
import java.util.Map;

public class CloneLLRandomAndNext138M
{
    private static void printClone(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data+ " ");
            if(head.random != null)
            {
                System.out.print(head.random.data);
            }
            /*else
            {
                System.out.print("null");
            }*/
            System.out.println();
            head = head.next;
        }
    }

    /*private static Node clonedLLBrute(Node head)
    {
        Node temp =head;
        Map<Node, Node> mpp = new HashMap<>();
        // copying the nodes into haspmap
        while(temp != null)
        {
            Node newNode = new Node(temp.data);
            mpp.put(temp, newNode);
            temp = temp.next;
        }

        temp =head;
        // Step 2: Connect the next and random
        // pointers of the copied nodes using the map
        while(temp != null)
        {
            // Access the copied node corresponding
            // to the current original node
            Node copy = mpp.get(temp);
            copy.next = mpp.get(temp.next);
            copy.random = mpp.get(temp.random);
            temp = temp.next;
        }
        return mpp.get(head);

    }
    */

    private static Node cloneLLOptimal(Node head)
    {
        if (head == null) return null;
        Node temp = head;
        while(temp != null)
        {
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        temp =head;
        while(temp != null)
        {
            Node copyNode = temp.next;
            if(temp.random != null)
                copyNode.random = temp.random.next;
            else
                copyNode.random = null;
            temp= temp.next.next;
        }

        temp =head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp != null)
        {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }

        return dummy.next;
    }
    public static void main(String[] args)
    {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClone(head);


       // Node clone = clonedLLBrute(head);
        Node clone  = cloneLLOptimal(head);
        System.out.println("cloned Linked List with Random Pointers:");
        printClone(clone);
    }

    static class Node
    {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node random) {
            this.data = data;
            this.next = next;
            this.random = random;
        }
    }

}
