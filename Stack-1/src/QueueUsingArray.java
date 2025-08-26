import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingArray {
    public static void main(String[] args) {
        // This is for Inbuilt Queue interface for and the operations also inbuilt
        /*
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(140);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        */

        // Create an instance of the custom Queue
        Queuew q = new Queuew();
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);

        System.out.println(q. toString());
        System.out.println("Top of the queue is: " + q.top());
        System.out.println("Popped element: " + q.pop());
        System.out.println("Length of the queue: " + q.size());
    }
}

class Queuew {
    private int start = -1;
    private int end = -1;
    private int curSize = 0;
    private int size = 100;
    private int[] arr = new int[size];

    void push(int x) {
        if (curSize == size) {
            System.out.println("Can't perform or add: Queue is full");
            return;
        }
        if (curSize == 0) {
            start = end = 0;
        } else {
            end = (end + 1) % size;
        }
        arr[end] = x;
        curSize += 1;
    }

    int pop() {
        if (curSize == 0) {
            System.out.println("Can't pop: Queue is empty");
            return -1; // Error value
        }
        int ele = arr[start];
        if (curSize == 1) {
            start = end = -1; // Reset the queue
        } else {
            start = (start + 1) % size;
        }
        curSize -= 1;
        return ele;
    }

    int top() {
        if (curSize == 0) {
            System.out.println("Can't peek: Queue is empty");
            return -1; // Error value
        }
        return arr[start];
    }

    int size() {
        return curSize;
    }

    @Override
    public String toString() {
        if (curSize == 0) {
            return "Queue is empty";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Elements in the queue: ");
        for (int i = 0; i < curSize; i++) {
            // Calculate the current index in the circular array
            int index = (start + i) % size;
            sb.append(arr[index]).append(" ");
        }
        return sb.toString();
    }
}