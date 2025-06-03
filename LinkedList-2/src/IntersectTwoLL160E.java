import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IntersectTwoLL160E
{
    private static Node convertArrLL(int[] arr1)
    {
        if(arr1.length == 0)
            return null;
        Node head = new Node(arr1[0]);
        Node temp = head;
        for(int i=1; i<arr1.length; i++)
        {
            temp.next = new Node(arr1[i]);
            temp = temp.next;
        }
        return head;
    }
    private static void print(Node head)
    {
        if (head == null) {
            System.out.println("No intersection.");
            return;
        }
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*private static Node intersectFirstBrute(Node l1, Node l2)
    {
        // Create a Map with Node as the key and Integer as the value
        Map<Node, Integer> mpp = new HASHmAP<>();
        Node temp1 = l1;
        while(temp1 != null)
        {
            mpp.add(temp1);
            temp1 = temp1.next;
        }
        Node temp2 =  l2;
        while(temp2 != null)
        {
            if(mpp.contains(temp2))
            {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;

    }*/

    private static Node intersectFirstOptimal(Node l1, Node l2)
    {
        if(l1 == null || l2 == null)
            return null;
        Node temp1 = l1;
        Node temp2 = l2;
        while(temp1 != temp2)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2)
                return temp1;
            if(temp1 == null)
                temp1 = l2;
            if(temp2 == null)
                temp2 = l1;
        }
        return temp1;
    }
    public static void main(String[] args) {
        int[] arr1 = {4,1,8,4,5};
        int[] arr2 = {5,6,1,8,4,5};
        Node head1 = convertArrLL(arr1);
        Node head2 = convertArrLL(arr2);
        //Node head = intersectFirstBrute(head1, head2);
        Node head = intersectFirstOptimal(head1, head2);
        if(head != null)
        {
            System.out.println("Intersect at node" + " " + head.data);
        }
        else {
            print(head);
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
