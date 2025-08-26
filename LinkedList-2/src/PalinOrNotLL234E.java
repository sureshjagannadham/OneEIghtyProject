import java.util.Stack;

public class PalinOrNotLL234E {

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

    /*private static boolean palindromeBrute(Node head)
    {
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null)
        {
            st.push(temp.data);
            temp = temp.next;
        }
         temp = head;
        while(temp != null)
        {
            if(temp.data != st.pop())
            {
                return false;
            }
            temp= temp.next;
            //st.pop();
        }
        return true;
    }*/
    private static Node reverseHalf(Node head)
    {
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    private static boolean palindromeOptimal(Node head)
    {
        if(head == null || head.next == null)
            return true;
        // step-1
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        // step-2
        Node newHead = reverseHalf(slow.next);
        // step-3 compare
        Node first = head;
        Node second = newHead;
        while(second != null)
        {
            if(first.data != second.data)
            {
                reverseHalf(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseHalf(newHead); // bcz we should not alter the original data
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        Node head = convertArrLL(arr);
        //boolean palin = palindromeBrute(head);
        boolean palin = palindromeOptimal(head);
        System.out.println(palin);
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
