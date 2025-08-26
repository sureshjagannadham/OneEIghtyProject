package logic_building_i1;

public class HowManyTimesArrayRotatedNine
{
    public static void main(String[] args)
    {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(timesRotated(arr));
    }
    static int timesRotated(int[] nums)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high])
            {
                if(nums[low] <ans)
                {
                    index = low;
                    ans = nums[low];
                }
                break;
            }
            if(nums[low] <= nums[mid])
            {
                if(nums[low] < ans)
                {
                    index = low;
                    ans = nums[low];
                }
                low = mid+1;
            }
            else
            {
                high = mid-1;
                if(nums[mid] < ans)
                {
                    index = mid;
                    ans = nums[mid];
                }
            }
        }
        return index;
    }
}
