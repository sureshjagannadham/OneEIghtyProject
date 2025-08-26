package faq_hard;

public class MaxProductSubarraySix
{
    public static void main(String[] args)
    {
        int[] arr = {2,3,-2,4};
        //System.out.println(maxProduct(arr));
        System.out.println(maxProductOptimal(arr));
    }
    /*public static int maxProduct(int[] nums)
    {
        int maxi = Integer.MIN_VALUE;
        int n =nums.length;
        for(int i=0; i<n; i++)
        {
            int product = 1;
            for(int j=i; j<n; j++)
            {
                product = product * nums[j];
                maxi = Math.max(product, maxi);
            }
        }
        return maxi;
    }*/

    public static int maxProductOptimal(int[] nums)
    {
        int prefix = 1;
        int suffix = 1;
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n-1; i++)
        {
            if(prefix == 0)
                prefix =1;
            if(suffix == 0)
                suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }
}
