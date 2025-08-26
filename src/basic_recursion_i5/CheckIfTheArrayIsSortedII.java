package basic_recursion_i5;

public class CheckIfTheArrayIsSortedII
{
    public static void main(String[] args)
    {
        int[] nums = {1,3,5,7,11,9};
        System.out.println(sort(nums, 0));

    }
    static boolean sort(int[] nums, int index)
    {
        if(index == nums.length-1)
            return true;
        if(nums[index] > nums[index+1])
            return false;
        return sort(nums, index+1);
    }
}
