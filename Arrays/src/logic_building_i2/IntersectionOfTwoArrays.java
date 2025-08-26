package logic_building_i2;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 4, 5};
        int[] arr2 = {2, 3, 5, 2, 5, 6};
        //System.out.println(Arrays.toString(inter(arr1, arr2)));
        System.out.println(Arrays.toString(optimal(arr1,arr2)));

    }
    /*static int[] inter(int[] num1, int[] num2)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] inter = new int[num1.length];
        int k =0;
        for(int i=0; i<num1.length; i++)
        {
            hm.put(num1[i], hm.getOrDefault(num1[i],0)+1);
        }
        for(int j=0; j<num2.length; j++)
        {
            if(hm.containsKey(num2[j]))
            {
                inter[k++] = num2[j];
                hm.put(num2[j], -1);       // Mark it as used
            }
        }
        int[] result = new int[k];
        for(int x = 0; x<k; x++)
        {
            result[x] = inter[x];
        }
        return result;

    }*/

    static int[] optimal(int[] nums1, int[] nums2)
    {
        int i=0; int j=0; int k=0;
        int[] result = new int[nums1.length];
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums2[j] < nums1[i])
            {
                j++;
            }
            else {
                // Match found
                if (k == 0 || result[k - 1] != nums1[i])
                {
                    result[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        int[] answer = new int[k];
        for(int x = 0; x<k; x++)
        {
            answer[x] = result[x];
        }
        return answer;

    }

}
