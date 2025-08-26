public class AddTwoNumbers2M {
    // For this no brute or better solution directly OPTIMAL APPROACH
    // TC-> maximum of O(N1,N2) of the linkedlist bcz I have to traverse either of them completely
    //SC-> O(N) // BCZ EVERYTIME I AM CREATING NODE FOR N TIMES OF LL
    private static Node convertArrLL(int[] arr)
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
    private static Node addTwoNumbers(Node l1, Node l2)
    {
        Node dumm = new Node(0);
        Node temp = dumm;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1)
        {
            int sum =0;
            if(l1 != null)
            {
                sum = sum + l1.data;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                sum = sum + l2.data;
                l2 = l2.next;
            }

            sum = sum +carry;
            carry = sum/10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dumm.next;
    }
    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,7,9};
        Node head1 = convertArrLL(arr1);
        Node head2 = convertArrLL(arr2);
        Node head = addTwoNumbers(head1, head2);
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
