package faq_i3;

import java.util.Arrays;

public class AggressiveCowsTwo
{
    public static void main(String[] args)
    {
        int[] arr = {2, 12, 11, 3, 26, 7}; //{10, 1, 2, 7, 5};//{1, 2, 4, 8, 9};
        int k = 5; //3;
        System.out.println(cows(arr,k));
    }
    static int cows(int[] stalls, int k)
    {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = stalls[0];
        int high = stalls[n-1];
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(stalls, mid, k))
            {
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return high;
        // why returning high means bcz high is at impossible stage and low is at possible stage
        // while trvarsing low is going to impossible stage and high is coming to possible stage
        // that's why returning high
    }
    static boolean isPossible(int[] nums, int dist, int k)
    {
        int countCows = 1;
        int last = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] - last >= dist)
            {
                countCows++;
                last = nums[i];
            }
            if(countCows >= k)
                return true;
        }
        return false;
    }



}
