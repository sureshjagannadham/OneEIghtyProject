import java.util.HashMap;
import java.util.HashSet;

public class MajorityElementNby2Times169E {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,2,2};
        //System.out.println(majorityBrute(nums));
        //System.out.println(majorityBetter(nums));
        System.out.println(majorityOptimal(nums));

    }
   /* static int majorityBrute(int[] nums)
    {
        int n= nums.length;
        for(int i=0; i<n; i++)
        {
            int count =0;
            for(int j=0; j<n; j++){
                if(nums[j] == nums[i])
                {
                    count ++;
                }
            }
            if(count > n/2)
            {
                return (nums[i]);
            }
        }
        return -1;
    }*/

    /*static int majorityBetter(int[] nums)
    {
        int n= nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            int num = nums[i];
            map.put(num, map.getOrDefault(num,0) +1);
        }
        for(int i=0; i<n; i++)
        {
            int num = nums[i];
            if(map.get(num) > n/2)
            {
                return num;
            }
        }
        return -1;
    }*/

    static int majorityOptimal(int[] nums)
    {
        int count =0;
        int ele = 0;
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(count == 0)
            {
                count =1;
                ele = nums[i];
            }
            else if(nums[i] == ele)
            {
                count ++;
            }
            else{
                count--;
            }
        }
        int count1 = 0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == ele)
            {
                count1++;
            }
        }
        if(count1 > n/2)
            return ele;
        return -1;

    }
}
