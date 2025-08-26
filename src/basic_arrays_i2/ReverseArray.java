//Time Complexity: O(n) – You scan each pair once.

//Space Complexity: O(1) – Just a loop variable.
package basic_arrays_i2;

import java.util.Arrays;

public class ReverseArray
{
    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(reverseArray(arr)));

    }
    static int[] reverseArray(int[] arr)
    {
        int start = 0;
        int end = arr.length-1;
        while(start<= end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

}
