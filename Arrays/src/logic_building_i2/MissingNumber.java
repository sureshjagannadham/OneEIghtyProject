package logic_building_i2;

public class MissingNumber
{
    public static void main(String[] args)
    {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));

    }
    public static int missingNumber(int[] nums)
    {
        int n = nums.length;
        int xor = 0;
        for(int i=0; i<n; i++)
        {
            xor = xor ^ i ^ nums[i];
        }
        xor = xor ^ n;
        return xor;
    }
    /*public static int missingNumber(int[] nums)
    {
        int n = nums.length;
        if(nums.length == 0)
            return 0;
        int total = n * (n+1) /2;
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum = sum + nums[i];
        }
        return total -sum;
    }*/
}
