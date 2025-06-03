import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131M
{
    public static void main(String[] args)
    {
        String s = "aabb";
        List<List<String>> ans = partition(s);
        System.out.println(ans);
    }

    static void helper(int index, String s, ArrayList<String> ds, List<List<String>> ans)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i =index; i<s.length(); i++)
        {
            if(isPalindrome(s,index,i))
            {
                ds.add(s.substring(index, i+1));
                helper(i+1, s, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }

   static  boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start ++) != s.charAt(end--))
            {
                return false;
            }
        }
        return true;
    }
    static List<List<String>> partition(String s)
    {
        List<List<String>> ans = new ArrayList<>();
        helper(0,s,new ArrayList<>(), ans);
        return ans;
    }
}
