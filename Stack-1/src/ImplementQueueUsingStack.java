import java.util.Stack;

public class ImplementQueueUsingStack
{
    public static void main(String[] args)
    {
        Quee q = new Quee();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println("top" + " " +q.top());
        System.out.println("pop" + " " +q.pop());
        q.push(1);
        System.out.println("pop" + " " +q.pop());
        System.out.println("pop" + " " +q.pop());
        System.out.println("pop" + " " +q.pop());
        System.out.println("top" + " " +q.top());
        System.out.println("pop" + " " +q.pop());
    }
}

class Quee
{
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    void push(int x)
    {
        st1.add(x);
    }
    int top()
    {
        // Transfer elements from st1 to st2 only if st2 is empty
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek(); // Get the top of the second stack
    }

    int pop()
    {
        // Transfer elements from st1 to st2 only if st2 is empty
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop(); // Pop the top of the second stack
    }
    public int size() {
        return st1.size() + st2.size();
    }
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }

}
