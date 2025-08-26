import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesSortedArray26E
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,2,3,4,4,4,5,6,7,7,8};
        //System.out.println(removeduplicatesBrute(arr));
        System.out.println(removeduplicatesOptimal(arr));
    }
   /* static int removeduplicatesBrute(int[] nums)
    {
        //Time complexity: O(n*log(n))+O(n)
        //Space Complexity: O(n)
        int n = nums.length;
        Set<Integer> st = new LinkedHashSet<>();
        for(int i=0; i<n; i++)
        {
            st.add(nums[i]);
        }
        int index =0;
        for(int it: st)
        {
            nums[index] = it;
            index++;
        }
        return st.size();
    }*/

    static int removeduplicatesOptimal(int[] nums)
    {
        //Time Complexity: O(N)
        // Space Complexity: O(1)
        int i = 0;
        for(int j=1; j<nums.length; j++)
        {
            if(nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}
