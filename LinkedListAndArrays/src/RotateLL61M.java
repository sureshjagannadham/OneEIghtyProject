public class RotateLL61M {

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
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node findKth(Node temp, int k)
    {
        int count =1;
        while(temp != null)
        {
            if(count == k)
                return temp;
            count++;
            temp = temp.next;
        }
        return temp;
    }

    private static Node rotateLL(Node head, int k)
    {
        if(head == null || k==0)
            return head;
        Node tail =head;
        int len = 1;
        while(tail.next != null)
        {
            len ++;
            tail = tail.next;
        }
        if(k % len == 0)
            return head;
        k = k % len;
        tail.next =head;
        Node newLast = findKth(head, len -k);
        head = newLast.next;
        newLast.next =null;
        return head;
    }


    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        int k =6;
        Node head = convertArrLL(arr);
        head = rotateLL(head,k);
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
