//Linear time complexity → O(n)
// Constant space complexity → O(1)

package basic_arrays_i2;

public class SumOfArrayElements
{
    public static void main(String[] args)
    {
        int[] arr = {4,7,1,3,9};
        System.out.println(sumOfElements((arr)));

    }
    static int sumOfElements(int[] arr)
    {
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            sum = sum +arr[i];
        }
        return sum;
    }

}
