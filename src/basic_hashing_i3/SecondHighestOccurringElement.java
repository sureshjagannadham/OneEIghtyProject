package basic_hashing_i3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondHighestOccurringElement
{
    public static void main(String[] args)
    {
        int[] nums = {2, 3, 5, 3, 2, 3, 4, 2, 2, 5, 5, 4, 4,6, 7, 6, 8, 9, 10};
        secondHighestOccurringElement(nums);
    }
    static void secondHighestOccurringElement(int[] nums)
    {
        // create HashMap
        Map<Integer, Integer> mp = new HashMap<>();
        //2. find frequency of all numbers to store in map
        for(int i=0; i<nums.length; i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }

        // 3. Convert map to LIst
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet());

        // 4. sort the list by descending order
        list.sort((a,b)->b.getValue()-a.getValue());
        // Step 5: Handle edge case - only one unique element
        if (list.size() < 2) {
            System.out.println("Not enough unique elements for second highest frequency.");
            return;
        }
        // Step 6: Find the second highest frequency element
        int high = list.get(0).getValue();
        for(int i=1; i<list.size();i++)
        {
            if(list.get(i).getValue() < high)
            {
                System.out.println("Frequency: " + list.get(i).getValue());
                System.out.println("Second most frequent element: " + list.get(i).getKey());
                return;
            }
        }

        // Step 7: If all frequencies are the same
        System.out.println("No second highest frequency found — all elements have same count.");

    }
}
