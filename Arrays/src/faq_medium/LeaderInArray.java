package faq_medium;

import java.util.Arrays;
import java.util.Collections;

public class LeaderInArray
{
    public static void main(String[] args)
    {
        int[] arr = {16, 17, 4, 17, 3, 5, 2};
        //System.out.println(Arrays.toString(leader(arr)));
        System.out.println(Arrays.toString(leaderArray(arr)));
    }
    /*static int[] leader(int[] nums)
    {
        int n = nums.length;
        int[] result = new int[n];
        int k=0;
        for(int i=0; i<n-1; i++)
        {
            boolean isLead = true;
            for(int j =i+1; j< n; j++)
            {
                if(nums[i] < nums[j])
                {
                    isLead = false;
                    break;
                }

            }
            if(isLead == true)
            {
                result[k++] = nums[i];
            }
        }
        result[k++] = nums[nums.length-1];
        int[] res = new int[k];
        for(int i=0; i<k; i++)
        {
            res[i] = result[i];
        }
        return res;
    }*/

    static int[] leaderArray(int[] nums)
    {
        int n = nums.length;
        int k=0;
        int[] result = new int[n];
        int maxi = nums[n-1];
        result[k++] = maxi;
        for(int i=n-2; i>=0; i--)
        {
            if(nums[i] > maxi)
            {
                maxi = nums[i];
                result[k++] = maxi;
            }
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++)
        {
            res[i] = result[k-1-i];
        }
        return res;

    }
}
