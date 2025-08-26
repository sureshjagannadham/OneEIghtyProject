import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII90M
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,2,2,3,3};
        List<List<Integer>> all = subSetsNoDup(nums);
        System.out.println(all);

    }
    static List<List<Integer>> subSetsNoDup(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(),ansList);
        return ansList;
    }
    static void findSubsets(int index, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ansList)
    {
        ansList.add(new ArrayList<> (ds));
        for(int i=index; i<nums.length; i++)
        {
            if(i != index && nums[i] == nums[i-1])
                continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ansList);
            ds.remove(ds.size()-1);
        }
    }
}
