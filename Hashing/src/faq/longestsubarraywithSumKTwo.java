package faq;

import java.util.HashMap;
import java.util.Map;

public class longestsubarraywithSumKTwo
{
    public static void main(String[] args)
    {
        //int[] arr = {10, 5, 2, 7, 1, 9};
        int[] arr = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(longest(arr,k));
    }
    /*static int longest(int[] nums, int k)
    {
        int longest = 0;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            int sum = 0;
            for(int j=i; j<n; j++)
            {
                sum+=nums[j];
                if(sum == k) longest = Math.max(longest, j-i+1);
            }

        }
        return longest;
    }*/

    static int longest(int[] nums, int k)
    {
        int longest = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            sum += nums[i];
            if(sum == k)
            {
                longest = i+1;
            }
            if(mp.containsKey(sum - k))
            {
                int prev = mp.get(sum-k);
                longest = Math.max(longest, i-prev);
            }
            if(!mp.containsKey(sum))
                mp.put(sum,i);
        }
        return longest;
    }

}
