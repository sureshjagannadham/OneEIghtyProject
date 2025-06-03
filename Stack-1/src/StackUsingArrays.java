import java.util.Stack;

public class StackUsingArrays
{

    public static void main(String[] args)
    {

        // This is for Inbuilt stack class for and the operations also inbuilt
        /*
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println(st);
        System.out.println("top of the stack is :" + " " + st.peek());
        System.out.println("pop the element" + " " + st.pop());
        System.out.println("is empty" + " " + st.isEmpty());
        System.out.println("length of the stack" + " " + st.size());
        */


        // I want to use my custom stack class from stackArray

        StackArray st = new StackArray();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.toString());
        System.out.println("top of the stack is :" + " " + st.top());
        System.out.println("pop the element" + " " + st.pop());
        System.out.println("is empty" + " " + st.isEmpty());
        System.out.println("length of the stack" + " " + st.size());
        st.push(50);
        System.out.println("Stack Contents: " + st.toString());
        System.out.println("Top of the stack is: " + st.top());
        System.out.println("Is empty: " + st.isEmpty());
        System.out.println("Length of the stack: " + st.size());
    }

}


class  StackArray
{
    int top = -1;
    int size = 100;
    int[] arr = new int[size];
    void push(int x)
    {
        if(top >=size-1)
            System.out.println("overflow");
        top = top+1;
        arr[top] = x;
    }

    int top()
    {
        if(top == -1)
        {
            System.out.println("no top bcz it is empty");
        }
        return arr[top];
    }
    int pop()
    {
        if(top == -1)
        {
            System.out.println(" no pop");
            return -1;
        }
        return arr[top--];
    }
    int size()
    {
        return top +1;
    }
    boolean isEmpty()
    {
        return top == -1;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]);
            if (i < top) {
                sb.append(", "); // Add a comma for all but the last element
            }
        }
        sb.append("]");
        return sb.toString(); // Return the string representation of the stack
    }
}

