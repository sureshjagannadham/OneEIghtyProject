package faq;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumKThree {
    public static int countSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: sum 0 occurs once

        int sum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If (sum - k) seen before, add its frequency to count
            count += map.getOrDefault(sum - k, 0);

            // Update frequency of current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(countSubarrays(nums, k)); // Output: 2
    }
}

