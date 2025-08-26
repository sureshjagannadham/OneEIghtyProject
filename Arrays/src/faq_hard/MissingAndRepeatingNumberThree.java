package faq_hard;

import java.util.Arrays;

public class MissingAndRepeatingNumberThree
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,2,4};
        //System.out.println(Arrays.toString(missingAndRepeatingNumber(arr)));
        System.out.println(Arrays.toString(missingAndRepeatingNumberBetter(arr)));

    }
    /*static int[] missingAndRepeatingNumber(int[] nums)
    {
        int n = nums.length;
        int repeat = -1;
        int missing = -1;
        for(int i=1; i<=n; i++)
        {
            int count = 0;
            for(int j=0; j<n; j++)
            {
                if(nums[j] == i)
                {
                    count++;
                }
            }
            if(count == 2)
            {
                repeat = i;
            }
            if(count == 0)
            {
                missing = i;
            }
            if(repeat != -1 && missing != -1)
            {
                break;
            }
        }
        return new int[] { repeat, missing};
    }*/

    static int[] missingAndRepeatingNumberBetter(int[] nums)
    {
        int n = nums.length;
        int[] hash = new int[n+1];
        for(int i=0; i<n; i++)
        {
            hash[nums[i]]++;
        }
        int repeat = -1, missing = -1;

        for(int i=1; i<= n; i++)
        {
            if(hash[i] == 2)
            {
                repeat = i;
            }
            if(hash[i] == 0)
            {
                missing = i;
            }
            if(repeat != -1 && missing != -1)
                break;
        }
        return new int[] {repeat, missing};
    }


}
