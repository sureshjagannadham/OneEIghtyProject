public class MaxConsecutive1s485E
{
    public static void main(String[] args) {
        int[] arr = { 1,1,0,1,1,1,1,2,3,4,5,1,1,1,1,1,1,6};
        System.out.println(maxOnes(arr));
    }

    static int maxOnes(int[] nums)
    {
        int count= 0;
        int maxi =0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == 1)
            {
                count++;
                maxi = Math.max(maxi, count);
            }
            else
                count =0;
        }
        return maxi;
    }
}
