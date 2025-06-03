import java.util.HashSet;

public class MissingNumber268 {
    public static void main(String[] args) {
        int[] nums = {3,0,1,2};
        //System.out.println(missBetter(nums));
        //System.out.println(missOptimal1(nums));
        System.out.println(missOptimal2(nums));
    }

   /* static int missBetter(int[] nums)
    {
        int n = nums.length;
        HashSet<Integer> item = new HashSet<>();
        for(int i=0; i<n ;i++)
        {
            item.add(nums[i]);
        }
        for(int i=0; i<=n; i++)
        {
            if(!item.contains(i))
                return i;
        }
        return -1;
    }*/
    /*static int missOptimal1(int[] nums)
    {
        int n = nums.length;
        int sum =0;
        if(nums.length == 0)
            return 0;
        int total = n*(n+1)/2;
        for(int i=0; i<n; i++)
        {
            sum = sum +nums[i];
        }
        return total -sum;
    }*/

    static int missOptimal2(int[] nums)
    {
        int n = nums.length;
        int xor =0;
        for(int i=0; i<n; i++)
        {
            xor = xor ^ i ^ nums[i];
        }
        return xor = xor ^ n;
    }
}
