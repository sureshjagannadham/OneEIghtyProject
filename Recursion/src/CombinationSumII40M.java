import java.util.*;

public class CombinationSumII40M
{
    public static void main(String[] args)
    {
        int[] arr = { 10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2Optimal(arr, target);
        System.out.println(res);
    }

    /*static List<List<Integer>> combinationSum2(int[] nums, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
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
        helper(index+1, nums, target- nums[index], ds, ans);// Recurse with the same index to allow repeated use of the same element
        ds.remove(ds.size()-1); //backtrack

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }


        helper(index+1, nums, target, ds, ans); // Exclude the current element and move to the next index
    }*/

    static List<List<Integer>> combinationSum2Optimal(int[] nums, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int index =0;
        Arrays.sort(nums);
        helper(0,nums,target,new ArrayList<>(), ans);
        return ans;
    }

    static void helper(int index, int[] nums, int target, ArrayList<Integer> ds, List<List<Integer>> ans)
    {
        if(target ==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i= index; i<nums.length; i++)
        {
            if(i > index && nums[i] == nums[i-1])
                continue;
            if(nums[i] > target)
                break;
            ds.add(nums[i]);
            helper(i+1, nums, target-nums[i], ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}
