public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //System.out.println(maxSub(nums));
        System.out.println(maxSubOptimal(nums));
    }
    /*
    static int maxSub(int[] nums)
    {
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            int sum = 0;
            for(int j =i; j<nums.length; j++)
            {
                sum = sum +nums[j];
                maxi = Math.max(sum, maxi);
            }
        }
        return maxi;
    }*/

    static long maxSubOptimal(int[] nums)
    {
        long maxi = Long.MIN_VALUE;
        long sum =0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];

            if(sum >maxi)
                maxi = sum;
            if(sum <0)
                sum =0;
        }
        return maxi;
    }
}
