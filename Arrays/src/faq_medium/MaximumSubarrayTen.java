package faq_medium;

public class MaximumSubarrayTen
{
    public static void main(String[] args)
    {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums)
    {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            sum = sum + nums[i];
            if(sum > maxi)
                maxi = sum;
            if(sum < 0)
                sum = 0;
        }
        return maxi;
    }

}
