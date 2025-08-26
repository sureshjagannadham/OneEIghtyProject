package logic_building_i1;

import java.util.Arrays;

public class FirstLastPositionElementSortedArrayFive
{
    public static void main(String[] args)
    {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(arr,target)));
    }
    /*
    using lower and upper bound
    public static int[] searchRange(int[] nums, int target)
    {
        int first= lowerBound(nums,target);
        if(first == nums.length || nums[first] != target)
            return new int[] {-1,-1};
        int last = upperBound(nums,target)-1;
        return new int[]{first, last};
    }

    static int lowerBound(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] >= target)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    static int upperBound(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] >target)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
     */
    // using plain binary search
    public static int[] searchRange(int[] nums, int target)
    {
        int n = nums.length;
        int ans1 = first(nums,target,n);
        int ans2 = last(nums,target,n);
        return new int[]{ans1,ans2};
    }
    public static int first(int[]nums, int target, int n)
    {
        int low = 0;
        int high = n-1;
        int first = -1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return first;
    }

    public static int last(int[]nums, int target, int n)
    {
        int low = 0;
        int high = n-1;
        int last = -1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                last =mid;
                low = mid+1;
            }
            else if(nums[mid] > target)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return last;
    }

}
