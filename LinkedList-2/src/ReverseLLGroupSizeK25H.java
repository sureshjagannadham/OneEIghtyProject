public class ReverseLLGroupSizeK25H
{
    private static void print(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    private static Node convertArrToLL(int[] arr)
    {
        if(arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node temp =head;
        for(int i=1; i<arr.length; i++)
        {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    private static Node reverseL(Node head)
    {
        Node temp =head;
        Node prev = null;
        while(temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp =front;
        }
        return prev;
    }

    private static Node  kthNode(Node temp, int K)
    {
        K = K-1;
        while(temp != null && K>0)
        {
            K--;
            temp = temp.next;
        }
        return temp;
    }

    private static Node groupSizeK(Node head, int K)
    {
        Node temp = head;
        Node prevL = null;
        while(temp != null)
        {
            Node Knode = kthNode(temp, K);
            if(Knode == null)
            {
                if(prevL != null)
                {
                    prevL.next = temp;
                    break;
                }
            }
            Node nextNode = Knode.next;
            Knode.next = null;
            reverseL(temp);
            if(temp == head)
                head = Knode;
            else{
                prevL.next = Knode;
            }
            prevL = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,12};
        Node head = convertArrToLL(arr);
        int k =3;
        head = groupSizeK(head, k);
        print(head);
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
