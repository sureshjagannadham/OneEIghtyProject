import java.util.*;

public class ThreeSum15M {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        //List<List<Integer>> res = threeSumBrute(arr);
        //List<List<Integer>> res = threeSumBetter(arr);
        List<List<Integer>> res = threeSumOptimal(arr);
        for(List<Integer> all : res)
        {
            System.out.println(all);
        }
        System.out.println();

    }

    /*static List<List<Integer>> threeSumBrute(int[] nums)
    {
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                for(int k=j+1; k<n; k++)
                {
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        List<Integer> temp =Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }*/

   /* static List<List<Integer>> threeSumBetter(int[] nums)
    {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            Set<Integer> hashSet = new HashSet<>();
            for(int j= i+1; j<n; j++)
            {
                int third = -(nums[i] + nums[j]);
                if(hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(st);
    }*/

    static List<List<Integer>> threeSumOptimal(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(i >0 && nums[i] == nums[i-1])
                continue;
            int j= i+1;
            int k = n-1;
            while(j<k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0)
                {
                    j++;
                }
                else if(sum >0)
                {
                    k--;
                }
                else
                {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])
                    {
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1])
                    {
                        k--;
                    }
                }
            }
        }
        return ans;
    }

}
