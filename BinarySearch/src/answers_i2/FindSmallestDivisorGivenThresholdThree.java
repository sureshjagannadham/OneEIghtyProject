package answers_i2;

public class FindSmallestDivisorGivenThresholdThree
{
    public static void main(String[] args)
    {
        int[] arr = {44,22,33,11,1};//{1,2,5,9};
        int threshold = 5; //6;
        System.out.println(findSmallestDivisorGivenThreshold(arr,threshold));
    }
    static int findSmallestDivisorGivenThreshold(int[] nums, int t)
    {
        int n = nums.length;
        if(n > t)
            return -1;
        int low =1;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi = Math.max(maxi, nums[i]);
        }
        int high = maxi;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(sumByMid(nums, mid) <= t)
            {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    private static int sumByMid(int[] nums, int mid)
    {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n ;i++)
        {
            sum += Math.ceil((double)(nums[i])/(double)(mid));
        }
        return sum;
    }
}
