import java.util.Arrays;
import java.util.Collections;
public class NextPermutation {
    public static void main(String[] args) {
        //int[] nums = {2,1,5,4,3,0,0};
        int[] nums = { 1,2,3,4,5};
        //int[] nums = {5,4,3,2,1};

        //int[] ans = nextPer(nums);
        System.out.println(Arrays.toString(nextPer(nums)));
    }
    static int[] nextPer(int[] nums)
    {
        int n = nums.length;
        int index = -1;
        // why n-2 means it will start from there only
        // to find out where the dip placed
        for(int i = n-2; i>=0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                index = i;
                break;
            }
        }
        if(index ==-1)
        {
            int left = 0;
            int right = n-1;
            while(left < right)
            {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
            return nums;
        }

        for(int i= n-1; i> index; i--)
        {
            if(nums[i] > nums[index])
            {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        int left = index+1;
        int right = nums.length-1;
        while(left < right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
        return nums;
    }
}
