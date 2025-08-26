// Time Complexity: O(n)
// Space Complexity: O(n)
package basic_hashing_i3;

import java.util.HashMap;
import java.util.Map;

public class HighestFrequencyElement
{
    public static void main(String[] args)
    {
        int[] arr = {2, 3, 5, 3, 2, 3, 4, 2, 2};
        highestFrequencyElement(arr);

    }
    static void highestFrequencyElement(int[] arr)
    {
        // cretae HashMap
        Map<Integer, Integer> map = new HashMap<>();
        //2. find frequency of all numbers to store in map
        for(int i=0; i<arr.length; i++) {
            /*if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i]+1));
            }
            else {
                map.put(arr[i],1);
            }*/
            // or
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = 0;
        int maxEle = -1;
        for(Map.Entry<Integer, Integer> ele: map.entrySet())
        {
            if(ele.getValue() > maxFreq)
            {
                maxFreq = ele.getValue();
                maxEle = ele.getKey();
            }
        }
        System.out.println("maxFrequency :" + maxFreq);
        System.out.println("maxElement :" + maxEle);
    }

}
