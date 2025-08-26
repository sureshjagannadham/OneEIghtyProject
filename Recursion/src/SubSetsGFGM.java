import java.util.ArrayList;
import java.util.Collections;

//Time Complexity: O(2^n)+O(2^n log(2^n)). Each index has two ways. You can either pick it up or not pick it. So for n index time complexity for O(2^n) and for sorting it will take (2^n log(2^n)).
//
//Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an array of size n.

public class SubSetsGFGM
{
    public static void main(String[] args)
    {
        int[] arr = { 3,1,2};
        ArrayList<Integer> ans = subsetSums(arr);
        Collections.sort(ans);
        System.out.print(ans + " ");
    }
    static ArrayList<Integer> subsetSums(int[] arr)
    {
        int n = arr.length;
        ArrayList<Integer> sumset = new ArrayList<>();
        helper(0,0,arr,n,sumset);
        return sumset;
    }

    private static void helper(int index, int sum, int[] arr, int size, ArrayList<Integer> sumset)
    {
        //base condition
        if(index == size)
        {
            sumset.add(sum);
            return ;
        }
        // if we pick
        helper(index+1, sum +arr[index], arr, size, sumset);
        // if we not pick
        helper(index+1, sum, arr,size, sumset);
    }

}
