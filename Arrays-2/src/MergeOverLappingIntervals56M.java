import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MergeOverLappingIntervals56M {
    public static void main(String[] args) {
        int[][] intervals = { {1,3},{2,6},{8,10},{1,5},{15,18} };
       /* List<List<Integer>> asn = bruteList(intervals);
        System.out.println(asn);*/
        //int[][] output = overlapBrute(intervals);c
        int[][] output = overOptimal(intervals);
        for(int i=0; i<output.length; i++)
        {
            System.out.print("[" +output[i][0] + ", " + output[i][1]+ " " +"]");
        }

    }
    /*static int[][] overlapBrute(int[][] intervals)
    {
        int n = intervals.length;
        // sort the intervals using lambda expression and recommended to use
        Arrays.sort(intervals, (a, b) ->    Integer.compare(a[0], b[0]));
        // To store all the merge overlap intervals in the "ans" list
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int start= intervals[i][0];
            int end =  intervals[i][1];
            // ans list is not empty and also check end <= last index of the elemnt in ans list
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1))
            {
                continue;
            }
            for(int j=i+1; j<n; j++)
            {
                if(intervals[j][0] <= end)
                {
                    end = Math.max(end, intervals[j][1]);
                }
                else
                {
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        // converting list to 2d [][] int array
        int[][] merge = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++)
        {
            merge[i][0] = ans.get(i).get(0);
            merge[i][1] = ans.get(i).get(1);
        }
        return merge;
    }*/

    /*static List<List<Integer>> bruteList(int[][] intervals)
    {
        int n = intervals.length;
        // sort the intervals using lambda expression and recommended to use
        Arrays.sort(intervals, (a, b) ->    Integer.compare(a[0], b[0]));
        // To store all the merge overlap intervals in the "ans" list
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // ans list is not empty and also check end <= last index of the elemnt in ans list
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }*/

    static int[][] overOptimal(int[][] nums)
    {
        int n = nums.length;
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[1]));
        List<List<Integer>> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (all.isEmpty() || nums[i][0] > all.get(all.size() - 1).get(1)) {
                all.add(Arrays.asList(nums[i][0], nums[i][1]));
            } else {

                List<Integer> overlap = all.get(all.size() - 1);
                overlap.set(1, Math.max(overlap.get(1), nums[i][1]));


            }
        }
        int[][] merge = new int[all.size()][2];
        for(int i=0; i<all.size(); i++)
        {
            merge[i][0] = all.get(i).get(0);
            merge[i][1] = all.get(i).get(1);
        }
        return merge;
    }
}
