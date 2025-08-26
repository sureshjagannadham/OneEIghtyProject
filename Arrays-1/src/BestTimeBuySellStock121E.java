public class BestTimeBuySellStock121E {
    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 4, 6, 5};
        int ans = stock(nums);
        System.out.println(ans);
        // System.out.println(stock(nums));
    }
    static int stock(int[] nums)
    {
        int mini = nums[0];
        int profit = 0;
        for(int i=1; i<nums.length; i++)
        {
            int cost = nums[i] - mini;
            profit = Math.max(cost, profit);
            mini = Math.min(mini, nums[i]);
        }
        return profit;
    }
}
