package logic_building_i2;

import java.util.*;

public class UnionOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 2, 4, 5};
        int[] arr2 = {2, 3, 5, 6};
//        Set<Integer> result = unionOfTwoSortedArrays(arr1,arr2);
//        System.out.println(result);
        //System.out.println(Arrays.toString(union(arr1, arr2)));
        System.out.println(Arrays.toString(unionOptimal(arr1, arr2)));
    }
 /*   static Set<Integer>  unionOfTwoSortedArrays(int[] nums1, int[] nums2)
    {
        Set<Integer> unionSet = new TreeSet<>();
        for(int i=0; i<nums1.length; i++)
        {
            unionSet.add(nums1[i]);
        }
        for(int j=0; j<nums1.length; j++)
        {
            unionSet.add(nums2[j]);
        }
        return unionSet;
    }*/
    // Brute Force approach
    /*static int[] union(int[] num1, int[] num2)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<num1.length; i++)
        {
            hm.put(num1[i], hm.getOrDefault(num1[i], 0)+1);
        }
        for(int j=0; j<num2.length; j++)
        {
            hm.put(num2[j], hm.getOrDefault(num2[j], 0)+1);
        }

        for(int it:hm.keySet())
        {
            list.add(it);
        }
        int[] finals = new int[list.size()];
        for(int i=0; i<list.size(); i++)
        {
            finals[i] = list.get(i);
        }
        return finals;
    }*/

    static int[] unionOptimal(int[] num1, int[] num2)
    {
        int n1 = num1.length;
        int n2 = num2.length;
        int i=0;
        int j=0;
        int k=0;
        int[] union = new int[n1+n2];
        while(i <n1 && j<n2)
        {
            if(num1[i] <= num2[j])
            {
                if(k==0 || union[k-1] != num1[i])
                {
                    union[k++] = num1[i];

                }
                i++;
            }
            else
            {
                if(k == 0|| union[k-1] != num2[j])
                {
                    union[k++] = num2[j];
                }
                j++;
            }
        }

        while(i < n1)
        {
            if(k==0 || union[k-1] != num1[i])
            {
                union[k++] = num1[i];
            }
            i++;
        }

        while(j<n2)
        {
            if(k == 0|| union[k-1] != num2[j])
            {
                union[k++] = num2[j];
            }
            j++;
        }
        int[] result = new int[k];
        for(int x=0; x<k; x++)
        {
            result[x] = union[x];
        }
        return result;
    }


}
