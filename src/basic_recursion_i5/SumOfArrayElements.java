package basic_recursion_i5;

public class SumOfArrayElements
{
    public static void main(String[] args)
    {
        int[] arr = {2,4,6,8,10};
        System.out.println(sums(arr,0));
    }
    static int sums(int[] arr, int index)
    {
        if(arr.length == 0)
            return -1;
        if(index == arr.length)
            return 0;
        return arr[index] + sums(arr,index+1);
    }
}
