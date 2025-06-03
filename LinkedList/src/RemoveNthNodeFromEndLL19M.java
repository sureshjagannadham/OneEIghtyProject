public class RemoveNthNodeFromEndLL19M {
    private static Node convertArrLL(int[] arr)
    {
        if(arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++)
        {
            temp.next = new Node(arr[i]);
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
    }

    private static Node removeNth(Node head, int val)
    {
        Node fast = head;
        Node slow = head;

        for(int i=1; i<=val; i++)
        {
            fast = fast.next;
        }
        if(fast == null)
            return head.next;
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        //Node del = slow.next;
        slow.next = slow.next.next;
        //del = null;
        return head;
    }
    public static void main(String[] args)
    {
        int[] arr = {2,4,16,7,8,9};
        Node head = convertArrLL(arr);
        head = removeNth(head,6);
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
