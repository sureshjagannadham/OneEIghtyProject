package faq_medium;

import java.util.Arrays;

public class NextPermutationEleven {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println("Original array: " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next permutation: " + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        // 1. Find the dip from right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If array is in descending order
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }

        // 2. Find the next greater element and swap
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        // 3. Reverse the remaining suffix
        int left = index + 1;
        int right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

