package logic_building_i1;

public class SingleElementSortedArrayTen
{
    public static void main(String[] args)
    {
        int[] arr1 = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(singleElement(arr1));
    }
    // brute force approach
    /*
    static int singleElement(int[] nums)
    {
        int n = nums.length;
        if(n==1)
            return nums[0];
        for(int i=0; i<n; i++)
        {
            if(i ==0)
            {
                if(nums[i] != nums[i+1])
                    return nums[i];
            }
            else if(i==n-1)
            {
                if(nums[i] != nums[i-1])
                return nums[i];
            }
            else
            {
                if(nums[i] != nums[i-1] && nums[i] != nums[i+1])
                    return nums[i];
            }
        }
        return -1;
    }
       */

    static int singleElement(int[] nums)
    {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[n-1] != nums[n-2])
            return nums[n-1];
        int low = 1;
        int high = n-2;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            // mid at odd index and we need to look at left side equal to mid or not if equal should eliminte ledt portion
                // or mid at even index and look at right side equal to mid or not if equal should eliminte right portion
            else if(mid % 2 ==1 && nums[mid] == nums[mid-1] || mid % 2== 0 && nums[mid] == nums[mid+1])
                low = mid+1;
            else
                high  = mid-1;
        }
        return -1;

    }
}
