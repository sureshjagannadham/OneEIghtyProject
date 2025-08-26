package basic_recursion_i5;

public class PalindromeCheck
{
    public static void main(String[] args)
    {
        String s = "madam";
        System.out.println(palindrom(s, 0, s.length()-1));
        String s1 = "tarata";
        System.out.println(palin(s1,0));
    }
    static boolean palindrom(String s, int start, int end)
    {
        if(start >= end)
            return true;
        if(s.charAt(start) != s.charAt(end))
            return false;
        return palindrom(s, start+1, end-1);
    }
    static boolean palin(String s1, int index)
    {
        int n = s1.length();
        if(index>=n/2)
            return true;
        if(s1.charAt(index) != s1.charAt(n-index-1))
            return false;
        return palin(s1, index+1);

    }

}
