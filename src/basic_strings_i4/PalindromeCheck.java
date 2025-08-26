package basic_strings_i4;

public class PalindromeCheck
{
    public static void main(String[] args)
    {
        String s = "madam";
        System.out.println(palindrome(s));

    }
    static boolean palindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;
        while(start <= end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
