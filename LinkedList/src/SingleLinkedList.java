
public class SingleLinkedList
{
    //EveryLinkedList is having HEAD and TAIL
    private Node head;
    private Node tail;
    private int size;

    // need constructor to initialize the size of the linked list
    public SingleLinkedList() {
        this.size =0;
    }

    public void insertFrst(int val)
    {
        Node node = new Node(val); // to create a new node
        node.next = head; // head always points the first node
        head  = node;

        if(tail == null)
        {
            tail = head;
        }
        size += 1;
    }
    public void insertLst(int val)
    {
        if(tail == null)
        {
            insertFrst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insert(int val, int index) // insert a value at a particular index
    {
        if(index <0 || index >size)
        {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        /*if(index == 0);
        {
            insertFrst(val);
            return;
        }*/
        /*if(index == size)
        {
            insertLst(val);
            return;
        }*/

        Node temp = head;
        for(int i=1; i<index; i++)
        {
            temp = temp.next;

        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFrst()
    {
        int val = head.value;
        head = head.next;

        if(head == null)
        {
            tail =null;
        }
        size--;
        return val;
    }
    public int deleteLast()
    {
       if(size <= 1)
       {
           return deleteFrst();
       }
       Node secondLast = get(size-2);
       int val = tail.value;
       tail = secondLast;
       tail.next = null;
       return val;
    }

    public int delete(int index)
    {
        if(index ==0)
            return deleteFrst();
        if(index == size-1)
            return deleteLast();

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }
    public Node find(int val)
    {
        Node node = head;
        while(node != null)
        {
            if(node.value == val)
                return node;
        }
        node = node.next;
        return node;
    }
    public Node get(int index)
    {
        Node node = head;
        for(int i=0; i<index; i++)
        {
            node = node.next;
        }
        return node;
    }

    public void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }



    //linked list having a class that is node
    private class Node{
        private int value;
        private Node next;
        // I want a constructor that takes a simple value

        public Node(int value) {
            this.value = value;
        }

        // I want a constructor that takes both value and next

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }



}