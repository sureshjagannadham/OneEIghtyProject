
public class DoubleL
{
    private static void print(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static Node convertDLL(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++)
        {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static Node deleteHead(Node head)
    {
        if(head == null || head.next == null)
            return null;
        Node prev = head;
        head =  head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    static Node deleteTail(Node head)
    {
        if (head == null || head.next == null)
            return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.back;
        newTail.next = null;
        tail.back = null;
        return head;
    }

    private static Node deleteK(Node head, int K)
    {
        if(head ==  null)
            return null;
        int count =0;
        Node temp = head;
        while(temp != null)
        {
            count++;
            if(count == K)
                break;
            temp = temp.next;
        }
        Node prev =temp.back;
        Node front =temp.next;
        if(prev == null && front == null)
        {
            return null;
        }
        // deleting Head
        else if(prev == null)
        {
            return deleteHead(head);
        }
        else if(front == null)
        {
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;

        return head;
    }

    private static Node insertHead(Node head, int val)
    {
        Node newHead = new Node(val, head, null);
        if(head != null)
            head.back = newHead;
        return newHead;
    }
    // we are performing operations before the nodes/elements not after
    private static Node insertTail(Node head, int val)
    {
        /*if(head != null)
            return new Node(val, null, null);*/
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val,temp,prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    public static void main (String[]args)
    {
        int[] arr = {9, 4, 7, 3, 8};
        Node head = convertDLL(arr);
        //head = deleteHead(head);
        //head = deleteTail(head);
        //head = deleteK(head, 5);
        //head = insertHead(head, 10);
        head = insertTail(head,57);
        print(head);
    }



    static class Node
    {
        int data;
        Node next;
        Node back;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
            this.back = null;
        }

        public Node(int data, Node next, Node back)
        {
            this.data = data;
            this.next = next;
            this.back = back;
        }
    }
}
