package basic_arrays_i1;

public class LinearSearch
{
    public static void main(String[] args)
    {
        int[] arr = {5, 8, 12, 3, 9};
        int target = 12;
        System.out.println(findElement(arr, target));
    }
    static int findElement(int[] nums, int target)
    {
        if(nums.length == 0)
            return 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
                return i;
        }
        return -1;
    }

}
