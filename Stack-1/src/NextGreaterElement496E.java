import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement496E {
    public static void main(String[] args) {
        int[] arr2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreat( arr2)));
    }
    // BUT THIS APPROACH WILL NOT GIVE YOU TH EXACT OUTPUT
   /* static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            nge[i] = -1; // Default value if no greater element is found
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    nge[i] = arr[j];
                    break; // Exit the loop once the next greater element is found
                }
            }
        }
        return nge;
    }*/

        static int[] nextGreat(int[] arr2)
        {
            int[] nge = new int[arr2.length];
            Stack<Integer> st = new Stack<>();
            for(int i= arr2.length-1; i>=0; i--)
            {
                int ele = arr2[i];
                while(!st.isEmpty() && st.peek() <= ele)
                {
                    st.pop();
                }
                if(st.isEmpty())
                    nge[i] = -1;
                else
                    nge[i] = st.peek();
                st.push(ele);
            }
            return nge;
        }
    }