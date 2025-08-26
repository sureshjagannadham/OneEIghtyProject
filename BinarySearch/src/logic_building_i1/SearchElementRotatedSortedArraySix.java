package logic_building_i1;

public class SearchElementRotatedSortedArraySix
{
    public static void main(String[] args)
    {
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 1;
        System.out.println(searchElementRotatedSortedArray(arr, target));

    }
    static int searchElementRotatedSortedArray(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            // identifying the left sorted part
            if(nums[low] <= nums[mid])
            {
                    if(nums[low] <= target && target <= nums[mid])
                        high = mid-1;
                    else
                        low = mid+1;
            }
            // identifying the right sorted part
            else
            {
                if(nums[mid] <= target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
