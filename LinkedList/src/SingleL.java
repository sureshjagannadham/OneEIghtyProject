class Node
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

public class SingleL {
    // method to convert an array to  a linkedlist
    private static Node convertArrToLL(int[] arr)
    {
        if(arr.length ==0)
            return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    /*static int isPresent(Node head, int val)
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.data == val)
                return 1;
            temp = temp.next;
        }
        return 0;
    }*/
    /*static int len(Node head)
    {
        int count =0;
        Node temp = head;
        while(temp != null)
        {
            //System.out.print(temp.data + " ");
            temp = temp.next;
            count++;
        }
        return count;
    }*/
    private static void print(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    /*static Node deleteHead(Node head)
    {
        if(head == null)
            return head;
        head = head.next;
        return head;
    }*/

    /*private static Node deleteTail(Node head)
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        Node temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }*/
    /*private static Node deleteK(Node head, int K)
    {
        if(head == null)
            return head;
        if(K == 1)
        {
            //Node temp = head;
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            count++;
            if(count == K)
            {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }*/
    /*private static Node deleteEle(Node head, int ele)
    {
        if(head == null)
            return head;
        if(head.data == ele)
        {
            //Node temp = head;
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {

            if(temp.data == ele)
            {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }*/

    /*private static Node insertHead(Node head, int val)
    {
        if(head == null)
            return new Node(val);
        Node temp = new Node(head,val);
        return temp;
    }*/

   /* private static Node insertTail(Node head, int val)
    {
        if(head == null)
            return new Node(val);
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }*/
    /*private static Node insertK(Node head, int val, int K)
    {
        if(head == null)
        {
            if(K==1)
            {
                return new Node(val);
            }
            else
                return head;
        }
        if(K==1)
        {
            return new Node(head, val);
        }
        int count =0;
        Node temp =head;
        while(temp != null)
        {
            count++;
            if(count == (K-1))
            {
                Node x = new Node(temp.next, val);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
*/
   private static Node insertBeforeValue(Node head, int ele, int val)
   {
       if(head == null)
       {
               return null;
       }
       if(head.data==val)
       {
           return new Node(head, ele);
       }
       Node temp =head;
       while(temp.next != null)
       {
           if(temp.next.data == val)
           {
               Node x = new Node(temp.next, ele);
               temp.next = x;
               break;
           }
           temp = temp.next;
       }
       return head;
   }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        Node head = convertArrToLL(arr);
        //System.out.println(len(head));
        //System.out.println(isPresent(head,35));
        //head = deleteHead(head);
        //head = deleteTail(head);
        //head = deleteK(head, 3);
        //head = deleteEle(head, 1);
        //head = insertHead(head, 50);
        //head = insertTail(head,101);
        //head = insertK(head, 50,6);
        head = insertBeforeValue(head,73,1);
        print(head);
    }
}


