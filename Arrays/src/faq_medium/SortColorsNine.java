package faq_medium;

import java.util.Arrays;

public class SortColorsNine
{
    public static void main(String[] args)
    {
        int[] nums = {2, 0, 2, 1, 1, 0};
        //sortColorsOptimal(nums);
        sortColorsBrute(nums);
        System.out.println(Arrays.toString(nums));
    }
    /*static void sortColorsOptimal(int[] nums)
    {
        int n= nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high)
        {
            if(nums[mid] == 0)
            {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
                mid++;
            else
            {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }*/

    static void sortColorsBrute(int[] nums)
    {
        int c1 =0;
        int c2 = 0;
        int c3 =0;
        int n = nums.length;
        int[] res = new int[n];
        int k=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == 0)
                c1++;
            else if(nums[i] == 1)
                c2++;
            else
                c3++;
        }
        for(int i=0; i<c1; i++)
        {
            res[k++] = 0;
        }
        for(int i=c1; i<c1+c2; i++)
        {
            res[k++] = 1;
        }
        for(int i=c1+c2; i<n; i++)
        {
            res[k++] = 2;
        }
        for(int i =0; i<res.length; i++)
        {
            nums[i] = res[i];
        }
    }
}
