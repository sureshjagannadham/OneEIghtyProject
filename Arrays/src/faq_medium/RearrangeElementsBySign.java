package faq_medium;

import java.util.Arrays;

public class RearrangeElementsBySign
{
    public static void main(String[] args)
    {
        int[] arr = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    public static int[] rearrangeArray(int[] nums)
    {
        int posI = 0;
        int negI = 1;
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++)
        {
            if(nums[i] > 0)
            {
                result[posI] = nums[i];
                posI += 2;
            }
            else
            {
                result[negI] = nums[i];
                negI += 2;
            }
        }
        return result;
    }
}
