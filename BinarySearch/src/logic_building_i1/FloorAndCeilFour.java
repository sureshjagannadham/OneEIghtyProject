package logic_building_i1;

public class FloorAndCeilFour
{
    public static void main(String[] args)
    {
        int[] arr = {10,20,30,40,50};
        int target = 25;
        System.out.println(floorBS(arr, target));
        int k = 35;
        System.out.println(ceilBS(arr,k));
    }
    // floor -> largest value which is smaller than equal to x --> largest <= x
    static int floorBS(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] <= target)
            {
                ans = nums[mid];
                start = mid+1;
            }
            else
                end = mid-1;
        }
        return ans;
    }

    // ceil -> smallest value which is greater than equal to x --> smallest >= x
    static int ceilBS(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] >= target)
            {
                ans = nums[mid];
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return ans;
    }

}
