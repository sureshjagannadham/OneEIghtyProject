public class RepeatMissingNumber2965E {
    public static void main(String[] args) {
        int [][] nums = {{1,3} ,{2,2}};
        int[] result = miss(nums);
        System.out.println("repeat" + " " + result[0] + " ,"+ "miss" + " " +result[1]);
    }
    static int[] miss(int[][] nums)
    {
        int repeat = -1, miss = -1;
        int n = nums.length * nums[0].length;
        for(int i=1; i<=n; i++)
        {
            int count =0;
            for(int j=0; j<nums.length; j++)
            {
                for(int k=0; k<nums[j].length; k++)
                {
                    if(nums[j][k] == i)
                        count ++;
                }
            }
            if(count ==2)
                repeat = i;
            else if(count == 0)
                miss = i;

            if(repeat !=-1 && miss != -1)
                break;
        }
        return new int[]{repeat, miss};
    }
}
