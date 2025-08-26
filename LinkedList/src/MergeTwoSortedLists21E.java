public class MergeTwoSortedLists21E
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
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node mergeTwoLL(Node l1, Node l2)
    {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.data> l2.data)
        {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        Node result = l1;
        while(l1 != null && l2 != null)
        {
            Node tmp = null;
            while(l1 != null && l1.data <= l2.data)
            {
                tmp =l1;
                l1 = l1.next;
            }
            tmp.next =l2;

            //swap
            Node temp = l1;
            l1= l2;
            l2 = temp;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {3,4,8,10};
        int[] arr2 = {5,7,9,16,19,27};
        Node head1 = convertArrLL(arr1);
        Node head2 = convertArrLL(arr2);
        Node head = mergeTwoLL(head1, head2);
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
