package logic_building_i1;

public class BinarySearchDemo
{
    public static void main(String[] args)
    {
        int[] arr = {1,3,5,7,9,12,14,16};
        int target= 9;
        //System.out.println(binarySearch(arr, target));
        int start = 0;
        int end = arr.length-1;
        System.out.println(binarySearchRec(arr,target,start,end));
    }
    // iterative way
    static int binarySearch(int[] nums, int target)
    {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high)
        {
            //int mid = (low+high)/2;// if the search space is limited to int max
            // in the overflow case means int max-int max will give zero
            int mid = low+ (high-low)/2;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    // recursive way
    static int binarySearchRec(int[] nums, int target, int low, int high)
    {
        if(low> high)
            return -1;
        int mid = (low+high)/2;
        if(target == nums[mid])
            return mid;
        else if(target > nums[mid])
            return binarySearchRec(nums,target,mid+1,high);
        else
            return binarySearchRec(nums,target,low,mid-1);
    }
}
