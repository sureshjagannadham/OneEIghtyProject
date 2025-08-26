package faq_hard;
import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> result = majorityElement(nums);
        System.out.println("Majority elements (> n/3): " + result);
    }

    /*public static List<Integer> majorityElement(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            int count = 0;

            for(int j = 0; j < n; j++)
            {
                if(nums[i] == nums[j])
                    count++;
            }

            if(count > n/3 && !ans.contains(nums[i]))
                ans.add(nums[i]);
        }

        return ans;
    }*/

    public static List<Integer> majorityElement(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}

