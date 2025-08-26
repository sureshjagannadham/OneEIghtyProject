package basic_arrays_i1;

import java.util.Arrays;

public class LeftRotateByOne
{
    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 40, 50};
        //leftRotate(arr);
        System.out.println(Arrays.toString(leftRotate(arr)));
    }
    static int[] leftRotate(int[] arr)
    {
        if(arr.length == 0)
            return new int[] {};
        int first = arr[0];
        for(int i=0; i<arr.length-1; i++)
        {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = first;
        return arr;
    }
}
