package faq_medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumFive
{
    public static void main(String[] args)
    {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
    /*static int[] twoSum(int[] nums, int target)
    {
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }*/

    static int[] twoSum(int[] nums, int target)
    {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            int comp = target- nums[i];
            if(hm.containsKey(comp))
            {
                return new int[]{hm.get(comp), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
