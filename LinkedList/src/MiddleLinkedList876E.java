public class MiddleLinkedList876E
{
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

    private static Node middleLL(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /*private static void print(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }*/

    public static void main(String[] args) {
        int[] arr = { 1,3,5,6,7,9,11,12};
        Node head = convertArrLL(arr);
        head = middleLL(head);
        System.out.println(head.data);
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
