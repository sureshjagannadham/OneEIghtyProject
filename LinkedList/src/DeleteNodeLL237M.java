public class DeleteNodeLL237M {
    private static Node convertArrL(int[] arr)
    {
        if(arr.length ==0)
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
        System.out.println();
    }
    private static void deleteNode(Node node)
    {
        if(node == null|| node.next == null)
            return;
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,16,7,8,9};
        Node head = convertArrL(arr);
        Node del = head;
        while(del != null && del.data != 9)
        {
            del = del.next;
        }
        if(del != null)
        {
            deleteNode(del);
        }
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
