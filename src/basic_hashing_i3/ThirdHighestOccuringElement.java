package basic_hashing_i3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirdHighestOccuringElement
{
    public static void main(String[] args)
    {
        int[] nums = {2, 3, 5, 3, 2, 3, 4, 2, 2, 5, 5, 4, 4,6, 7, 6, 8, 9, 10};
        thirdHighestOccuringElement(nums);
    }
    static void thirdHighestOccuringElement(int[] nums)
    {
        // 1. create a hashmap
        Map<Integer, Integer> mp = new HashMap<>();
        //2. find the frequency and stored in the map
        for(int i=0; i<nums.length; i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i],0) +1);
        }

        //3. convert map to list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet());
        // 4. sort the list
        list.sort((a,b) -> b.getValue()-a.getValue());
        //5. get the thrid frequency element
        int lastHighFreq = list.get(0).getValue();
        int rank = 1;
        for(int i=1; i<list.size(); i++)
        {
            int currentFreq = list.get(i).getValue();
            if(currentFreq < lastHighFreq)
            {
                rank++;
                lastHighFreq = currentFreq;
            }
            if(rank == 3)
            {
                System.out.println("Third most frequent element: " + list.get(i).getKey());
                System.out.println("Frequency" + list.get(i).getValue());
                return;
            }
        }

    }

}
