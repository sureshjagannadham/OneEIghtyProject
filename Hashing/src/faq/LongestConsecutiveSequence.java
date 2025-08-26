package faq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence
{
    public static void main(String[] args)
    {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }
    // brute force approach working but time limit exceeds
    /*public static int longestConsecutive(int[] nums)
    {
        // working but time limit exceeded
        int n = nums.length;
        if (nums.length == 0) return 0;
        int largest = 1;
        for(int i=0; i<n; i++)
        {
            int count = 1;
            int x = nums[i];
            while(linear(nums, x+1) == true)
            {
                count += 1;
                x = x+1;
            }
            largest = Math.max(largest, count);
        }
        return largest;
    }
    public static boolean linear(int[] nums, int target)
    {
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                return true;
            }
        }
        return false;
    }*/


    /*public static int longestConsecutive(int[] nums)
    {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int largest = 1;
        int curCount = 0;
        int n = nums.length;
        int lastSmaller = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            if(nums[i]-1 == lastSmaller)
            {
                curCount++;
                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller)
            {
                curCount = 1;
                lastSmaller = nums[i];
            }
            largest = Math.max(largest, curCount);
        }
        return largest;
    }*/

    public static int longestConsecutive(int[] nums)
    {
        int n = nums.length;
        if(nums.length == 0)
            return 0;
        int largest =0;
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            st.add(nums[i]);
        }

        for(int num: st)
        {
            if(!st.contains(num-1))
            {
                int count = 1;
                int x = num;
                while(st.contains(x+1))
                {
                    x++;
                    count++;
                }
                largest = Math.max(largest, count);
            }
        }
        return largest;
    }
}
