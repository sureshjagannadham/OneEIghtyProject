import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceKth60H
{
    public static void main(String[] args)
    {
        int n =4;
        int k =17 ;
        String all = getPermutation(n,k);
        System.out.println(all);
    }
    static String getPermutation(int n, int k)
    {
        int fact =1;
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<n; i++)
        {
            fact= fact *i;
            res.add(i);
        }
        res.add(n);
        String ans ="";
        k = k-1;
        while(true)
        {
            ans = ans + " " + res.get(k/fact);
            res.remove(k/fact);
            if(res.size() == 0)
            {
                break;
            }
            k = k % fact;
            fact = fact / res.size();
        }
        return ans;
    }
}
