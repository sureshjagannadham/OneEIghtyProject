package logic_building_i1;

public class MinimumRotatedSortedArrayEight
{
    public static void main(String[] args)
    {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(minimimElement(arr));
    }
    public static int minimimElement(int[] nums)
    {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            // search space is already sorted then nums[low] will be always smaller in the search area
            if(nums[low] <= nums[high])
            {
                ans = Math.min(nums[low],ans);
                break;
            }

            if(nums[low] <= nums[mid])
            {
                ans = nums[low];
                low = mid+1;
            }
            else {
                ans = nums[mid];
                high = mid-1;
            }
        }
        return ans;
    }
}
