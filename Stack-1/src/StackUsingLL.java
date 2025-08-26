/*
class Node {
    int data; // Value of the node
    Node next; // Reference to the next node

    // Constructor for creating a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top; // Pointer to the top node
    private int size; // Size of the stack

    // Constructor to initialize the stack
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Method to push an element onto the stack
    public void push(int x) {
        Node newNode = new Node(x); // Create a new node
        newNode.next = top; // Link the new node with the current top
        top = newNode; // Update top to point to the new node
        size++; // Increase the size
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int poppedData = top.data; // Get the top element's data
        top = top.next; // Move the top pointer to the next node
        size--; // Decrease the size
        return poppedData; // Return the popped value
    }

    // Method to peek at the top element
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data; // Return the data of the top node
    }

    // Method to get the size of the stack
    public int size() {
        return size; // Return the current size
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null; // True if stack is empty
    }
}

public class StackUsingLL {
    public static void main(String[] args) {
        Stack stack = new Stack(); // Create a stack

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(60);

        System.out.println("Popped: " + stack.pop()); // Expected: 60
        System.out.println("Size: " + stack.size()); // Expected: 3
        System.out.println("Top: " + stack.top()); // Expected: 30
    }
}*/
