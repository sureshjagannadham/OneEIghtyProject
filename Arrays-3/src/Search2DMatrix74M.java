import java.util.Arrays;

public class Search2DMatrix74M {
    public static void main(String[] args) {
        int[][] nums = {
                {1,3,5,7},
                {9,11,13,15},
                {17,19,21}
        };
        int target = 13;
        System.out.println(Arrays.toString(search2D(nums,target)));
    }
    static int[] search2D(int[][] nums, int target)
    {
        int start = 0;
        int end = nums[0].length-1;
        while(start < nums.length && end >=0)
        {
            if(nums[start][end] == target)
                return new int[] {start, end};
            if(target > nums[start][end])
            {
                start++;
            }
            else {
                end--;
            }
        }
        return new int [] {-1,-1};
    }
}
