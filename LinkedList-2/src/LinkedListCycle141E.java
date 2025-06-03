import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle141E
{
    // BRUTEFORCH Approach -> WORKING
    // Time Complexity: O(n)
    //Space Complexity: O(n)
    /*private static boolean detectCycleBrute(Node head)
    {
        Map<Node, Integer> mpp = new HashMap<>();
        Node temp =head;
        while(temp != null)
        {
            if(mpp.containsKey(temp))
            {
                return true;
            }
            mpp.put(temp,1);
            temp = temp.next;
        }
        return false;
    }*/

    private static boolean detectCycleOptimal(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        head.next = two;
        two.next = three;
        three.next =four;
        four.next =five;
        five.next = three;
        /*if(detectCycleBrute(head))
            System.out.println("loop detected");
        else {
            System.out.println("not detected");
        }*/
        if(detectCycleOptimal(head))
            System.out.println("loop detected");
        else {
            System.out.println("not detected");
        }
        //print(head);
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
