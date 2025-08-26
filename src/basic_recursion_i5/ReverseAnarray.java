package basic_recursion_i5;

public class ReverseAnarray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 5, 7, 9};
        rever(arr, 0, arr.length-1);
        for(int it: arr)
        {
            System.out.print(it+ " ");
        }
    }
    static void rever(int[] nums, int start, int end)
    {
        if(start >= end)
            return ;
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        rever(nums,start+1, end-1);
    }
}
