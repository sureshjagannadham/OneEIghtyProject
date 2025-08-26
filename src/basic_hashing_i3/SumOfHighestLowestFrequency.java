package basic_hashing_i3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfHighestLowestFrequency
{
    public static void main(String[] args)
    {
        int[] nums = {2, 3, 5, 3, 2, 3, 4, 2, 2, 5, 5, 4, 4,6, 7, 6, 8};
        sumOfHighestLowestFrequency(nums);
    }
    static void sumOfHighestLowestFrequency(int[] nums)
    {
        // 1. create a hashmap
        Map<Integer, Integer> mp = new HashMap<>();
        //2. find the frequency and stored in the map
        for(int i=0; i<nums.length; i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i],0) +1);
        }

        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        List<Integer> keys = new ArrayList<>(mp.keySet());
        for(int i=0; i<keys.size(); i++)
        {
            int freq = mp.get(keys.get(i));
            if(freq > maxFreq)
                maxFreq = freq;
            if(freq < minFreq)
                minFreq = freq;
        }
        int sum = maxFreq + minFreq;
        System.out.println("Highest frequency: " + maxFreq);
        System.out.println("Lowest frequency: " + minFreq);
        System.out.println("Sum of highest and lowest frequencies: " + sum);
    }

}
