package logic_building_i1;

public class SearchElementRotatedSortedArrayIIDuplicatesSeven
{
    public static void main(String[] args)
    {
        //int[] arr = {3, 1, 2, 3, 3, 3, 3};
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int target = 3;
        System.out.println(searchElementRotatedSortedArrayIIDuplicates(arr, target));
    }

    public static boolean searchElementRotatedSortedArrayIIDuplicates(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            // checks for teh case to shrink when low, mid, high are same values
            if (nums[low] == nums[mid] && nums[mid] == nums[high])
            {
                low = low + 1;
                high = high - 1;
                continue;
            }
            // identifying the left sorted part
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // identifying the right sorted part
            else {
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }
        return false;
    }
}
