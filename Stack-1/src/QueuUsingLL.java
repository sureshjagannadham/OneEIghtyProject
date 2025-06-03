public class QueuUsingLL {

    public static void main(String[] args) {
        Queue queue = new Queue(); // Create a new queue

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front item: " + queue.top()); // Expected: 10
        System.out.println("Popped item: " + queue.pop());   // Expected: 10
        System.out.println("Front item after pop: " + queue.top()); // Expected: 20
        System.out.println("Queue size: " + queue.size());   // Expected: 2
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private int size;
    private Node start;
    private Node end;

    public Queue() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public void push(int x) {
        Node temp = new Node(x);
        if (end == null) { // If the queue is empty
            start = end = temp;
        } else {
            end.next = temp;
            end = temp; // Move end to the new node
        }
        size++;
    }

    public int pop() {
        if (start == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int poppedData = start.data; // Get the data from the front
        start = start.next; // Remove the front node
        if (start == null) {
            end = null; // If the queue is empty now, set end to null as well
        }
        size--;
        return poppedData; // Return the popped value
    }

    public int top() {
        if (start == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return start.data; // Return the front item
    }

    public int size() {
        return size; // Return the count of elements
    }
}