package faq_hard;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementI{
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        //int result = majorityElement(nums);
        //int result = majorityElementBetter(nums);
        int result = majorityElementOptimal(nums);
        System.out.println("Majority Element: " + result);
    }

    /*public static int majorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // If no majority element exists (not expected in LeetCode)
    }*/

    /*public static int majorityElementBetter(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1; // Should never happen in LeetCode as majority element is guaranteed
    }*/

    public static int majorityElementOptimal(int[] nums)
    {
        int count = 0;
        int ele = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                ele = nums[i];
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;
            }
        }

        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele) {
                count1++;
            }
        }

        if (count1 > n / 2)
            return ele;
        return -1;
    }

}

