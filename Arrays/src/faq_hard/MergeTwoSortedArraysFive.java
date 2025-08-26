package faq_hard;

import java.util.Arrays;

public class MergeTwoSortedArraysFive {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        // Print merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int left = 0, right = 0, index = 0;

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                nums3[index++] = nums1[left++];
            } else {
                nums3[index++] = nums2[right++];
            }
        }

        while (left < m)
            nums3[index++] = nums1[left++];
        while (right < n)
            nums3[index++] = nums2[right++];

        for (int i = 0; i < nums3.length; i++)
            nums1[i] = nums3[i];
    }*/

    static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int left = m-1;
        int right = n-1;
        int k = m+n-1;
        while(right>=0)
        {
            if(left>=0 && nums1[left] >= nums2[right])
            {
                nums1[k--] = nums1[left--];
            }
            else {
                nums1[k--] = nums2[right--];
            }
        }
    }
}

