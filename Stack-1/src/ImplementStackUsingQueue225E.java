import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue225E {
    public static void main(String[] args) {
        // this is customized stack
        Stacks st = new Stacks();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println("Top element: " + st.top()); // Expected: 40
        System.out.println("Popped: " + st.pop());     // Expected: 40
        System.out.println("Top element after pop: " + st.top()); // Expected: 30
        System.out.println("Stack size: " + st.size());   // Expected: 3
    }
}

class Stacks {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q.poll(); // Remove and return the front element
    }

    // Get the top element of the stack
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q.peek(); // Return the front element without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }

    // Check the size of the stack
    public int size() {
        return q.size();
    }
}