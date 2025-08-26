package logic_building_i1;

public class LowerBound
{
    public static void main(String[] args)
    {
        int[] arr = {1,3,5,7,9,12,14,16};
        int target= 8;
        System.out.println(lowerBound(arr,target)); // lower bound -> smallest index >= x
        System.out.println(upperBound(arr,target)); // upper bound -> smallest index > x
    }
    static int lowerBound(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        int ans = nums.length;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] >= target)
            {
                ans = mid;
                end = mid-1;

            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }

    static int upperBound(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        int ans = nums.length;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] > target)
            {
                ans = mid;
                end = mid-1;

            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
}
