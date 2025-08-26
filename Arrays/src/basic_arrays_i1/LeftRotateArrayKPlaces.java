package basic_arrays_i1;

import java.util.Arrays;

public class LeftRotateArrayKPlaces
{
    public static void main(String[] args)
    {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int k = 5;
        System.out.println(Arrays.toString((leftRotateArrayKPlaces(arr,k))));
    }
    static int[] leftRotateArrayKPlaces(int[] nums, int k)
    {
        int n = nums.length;
        k = k%n;
        revers(nums, 0,k-1);
        revers(nums,k, n-1);
        revers(nums, 0, n-1);
        return nums;
    }

    static void revers(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
