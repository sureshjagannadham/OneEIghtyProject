public class FlattenedLLHard {

    private static Node merge(Node l1, Node l2)
    {
        Node dummy = new Node(-1);
        Node result = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                result.child = l1;
                result = l1;
                l1 = l1.child;
            }
            else {
                result.child = l2;
                result =l2;
                l2 = l2.child;
            }
            result.next = null;
        }
        if(l1 != null)
        {
            result.child = l1;
        }
        else {
            result.child = l2;
        }
       /* if(dummy.child != null)
        {
            dummy.child.next =null;
        }*/
        return dummy.child;
    }

    private static Node flattenLL(Node head)
    {
        if(head == null || head.next == null)
            return head;
        Node mergedHead = flattenLL(head.next);
        head = merge(head,mergedHead);
        return head;
    }
    private static void printLL(Node head)
    {
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.child = new Node(2);
        head.child.child = new Node(3);

        head.next = new Node(4);
        head.next.child = new Node(5);

        head.next.next = new Node(7);
        head.next.next.child = new Node(8);
        head.next.next.child.child = new Node(9);

        head.next.next.next = new Node(10);
        head.next.next.next.child = new Node(12);
        Node flattened = flattenLL(head);
        printLL(flattened);

    }
    static class Node
    {
        int val;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node child) {
            this.val = val;
            this.next = next;
            this.child = child;
        }
    }
}
