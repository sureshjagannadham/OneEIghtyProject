import java.util.ArrayList;
import java.util.List;

public class CombinationSumI39M
{
    public static void main(String[] args)
    {
        int[] arr = { 2,3,6,7};
        int target = 7; 
        List<List<Integer>> res = combination(arr, target);
        System.out.println(res);
    }

    static List<List<Integer>> combination(int[] nums, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,target,new ArrayList<>(), ans);
        return ans;
    }

    static void helper(int index, int[] nums, int target, ArrayList<Integer> ds, List<List<Integer>> ans)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        if(index == nums.length ||  target < 0)
        {
            return;
        }
        ds.add(nums[index]); // Include the current element (nums[index])
        // if we pick
        helper(index, nums, target- nums[index], ds, ans);// Recurse with the same index to allow repeated use of the same element
        ds.remove(ds.size()-1); //backtrack

        helper(index+1, nums, target, ds, ans); // Exclude the current element and move to the next index

    }
}
