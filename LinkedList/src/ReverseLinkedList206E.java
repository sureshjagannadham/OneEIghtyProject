import java.util.Arrays;
import java.util.Stack;
public class ReverseLinkedList206E {
    private static void print(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data + " ");
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
    /*private static Node reverseLLBrute(Node head) // TC: O(N) -> SC O(N)
    {
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null)
        {
            st.push(temp.data);
            temp = temp.next;
        }
        temp =head;
        while(temp != null)
        {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }*/
    /*private static Node reverseLLBetter(Node head)  // TC: O(N) -> SC O(1)
    {
        Node temp = head;
        Node prev = null;
        while(temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp =front;
        }
        return prev;
    }*/
    // Recursion
    private static Node reverseRecursive(Node head)  // TC: O(N) -> SC O(1)
    {
        if(head == null || head.next == null)
            return head;
        Node newHead = reverseRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        /*Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        System.out.print("originallinked list");
        print(head);
        //int[] arr = { 1,4,6,8,9};
        head = reverseLL(head);
        // print reverse linkedlist
        System.out.print("reverse linkedlist");
        print(head);*/

        // To print arr to linkedlist like this way
        int[] arr = {3,6,81,4,91};
        Node head = convertArrToLL(arr);
        //head = reverseLLBrute(head);
        //head = reverseLLBetter(head);
        head = reverseRecursive(head);
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
