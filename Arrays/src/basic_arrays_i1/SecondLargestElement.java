package basic_arrays_i1;

import java.util.Arrays;

public class SecondLargestElement
{
    public static void main(String[] args)
    {
        int[] arr = {12, 45, 27, 67, 34};
        System.out.println(maxElement(arr));

    }
    static int maxElement(int[] nums)
    {
        if(nums.length < 2)
        {
            throw new IllegalArgumentException("not enough elemnts to get the second largest number");

        }
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] > firstMax)
            {
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if(nums[i] > secondMax && nums[i] != firstMax)
                secondMax = nums[i];
        }
        return secondMax;
    }
}
