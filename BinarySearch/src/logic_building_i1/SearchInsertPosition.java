package logic_building_i1;

public class SearchInsertPosition
{
    public static void main(String[] args)
    {
        int[] arr = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(arr,target));
        System.out.println(searchInsertRec(arr,target,0,arr.length-1));
    }
    public static int searchInsert(int[] nums, int target)
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
                start = mid+1;
        }
        return ans;
    }
    public static int searchInsertRec(int[] nums, int target, int start, int end)
    {
        if(start > end)
            return start;
        int mid = start + (end-start)/2;
        if(nums[mid] >= target)
            return searchInsertRec(nums,target,start,mid-1);
        else
            return searchInsertRec(nums,target,mid+1,end);
    }
}
