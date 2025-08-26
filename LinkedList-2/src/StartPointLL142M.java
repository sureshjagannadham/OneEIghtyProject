import java.util.HashMap;
import java.util.Map;

public class StartPointLL142M {

    /*private static Node startPointBrute(Node head)
    {
        Node temp =head;
        Map<Node, Integer> mpp = new HashMap<>();
        while(temp != null)
        {
            if(mpp.containsKey(temp))
            {
                return temp;
            }
            mpp.put(temp,1);
            temp = temp.next;
        }
        return null;
    }*/

    private static Node startPointOptimal(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                slow = head;
                while(slow != fast)
                {
                    slow =slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;
        node5.next = node3;
        Node head1 = node1;
        //Node loopStartNode = startPointBrute(head);
        Node loopStartNodes = startPointOptimal(head1);
        if (loopStartNodes != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNodes.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }

    static class Node
    {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }
}
