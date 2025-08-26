package basic_arrays_i1;

public class LargestElement
{
    public static void main(String[] args)
    {
        int[] arr = {12, 45, 23, 67, 34};
        System.out.println(maxElement(arr));

    }
    static int maxElement(int[] nums)
    {
        if(nums.length == 0)
            return 0;
        int max = nums[0];  // start with the first element
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }
}
