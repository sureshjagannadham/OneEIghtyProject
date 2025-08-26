package faq_hard;

import java.util.Arrays;

public class MergeSortFour
{
    public static void main(String[] args)
    {
        int[] arr = {3,1,2,4,1,5,2,6,4};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void mergeSort(int[] nums, int low, int high)
    {
        if(low>= high)
            return ;
        int mid = (low + high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low,mid,high);
    }

    static int[] merge(int[] nums, int low, int mid, int high)
    {
        int left =low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        while(left <= mid && right <= high)
        {
            if(nums[left] < nums[right])
            {
                temp[k++] = nums[left++];
            }
            else
            {
                temp[k++] = nums[right++];
            }
        }
        while(left <= mid)
        {
            temp[k++] = nums[left++];
        }
        while(right <= high)
        {
            temp[k++] = nums[right++];
        }

        for(int i=0; i<temp.length; i++)
        {
            nums[low+i] = temp[i];
        }
        return nums;
    }


}
