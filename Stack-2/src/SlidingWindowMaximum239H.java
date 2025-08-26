import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum239H
{
    public static void main(String[] args)
    {
        int[] arr = {4,0,-1,3,5,3,6,8};
        int k=3;
        //ArrayList<Integer> ans = maxSliding(arr,k);
        //System.out.println(ans.toString());


        // for optimized approach
        int[] all = maxiSliding(arr,k);
        System.out.println(Arrays.toString(all));
    }

    /*static ArrayList<Integer> maxSliding(int[] arr, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
       // int maxi =0;
        for(int i=0; i<=arr.length-k; i++)
        {
             int maxi = arr[i];
             for(int j = i; j< i+k; j++)
             {
                 maxi = Math.max(maxi, arr[j]);
             }
            ans.add(maxi);
        }
        return ans;
    }*/

    static int[] maxiSliding(int[] arr, int k)
    {
        int n= arr.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int r = 0;
        for(int i=0; i<n; i++)
        {
            if(!q.isEmpty() && q.peek() == i-k)
                q.poll();
            while(!q.isEmpty() && arr[q.peekLast()] < arr[i])
            {
                q.pollLast();
            }

            q.offer(i);

            if(i >= k-1)
            {
                ans[r++] = arr[q.peek()];
            }
        }
        return ans;

    }


}
