import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement
{
    public static void main(String[] args)
    {
        //int[] arr = {4,5,2,10,8};
        int[] arr = {5,7,9,6,7,4};
        System.out.println(Arrays.toString(nextSmaller(arr)));
    }

    static int[] nextSmaller(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        int[] negS = new int[arr.length];
        for(int i =0; i< arr.length; i++)
        {
            int ele = arr[i];
            while(!st.isEmpty() && st.peek() >= ele)
            {
                st.pop();
            }
            if(st.isEmpty())
                negS[i] = -1;

            else
                negS[i] = st.peek();
            st.push(ele);
        }
        return negS;
    }
}
// int i =0; i< arr.length; i++
//[-1, 5, 7, 5, 6, -1]