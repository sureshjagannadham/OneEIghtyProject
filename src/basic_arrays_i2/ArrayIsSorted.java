//Time Complexity: O(n) – You scan each pair once.

//Space Complexity: O(1) – Just a loop variable.

package basic_arrays_i2;

public class ArrayIsSorted
{
    public static void main(String[] args)
    {
        int[] arr = {1,3,5,7,9};
        System.out.println(arrayIsSorted(arr));

    }
    static boolean arrayIsSorted(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

}
