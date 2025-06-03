import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPermutationsArray46M
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3};
        List<List<Integer>> all = permute(arr);
        System.out.println(all);
    }
    static void helper(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> ans)
    {
        if(ds.size() == nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length; i++)
        {
            if(!freq[i])
            {
               freq[i] = true;
               ds.add(nums[i]);
               helper(nums, freq, ds, ans);
               ds.remove(ds.size()-1);
               freq[i] = false;
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        helper(nums,freq,ds, ans);
        return ans;

    }
}
