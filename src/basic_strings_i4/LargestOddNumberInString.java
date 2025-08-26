package basic_strings_i4;

public class LargestOddNumberInString
{
    public static void main(String[] args)
    {
        String s = "843246";
        System.out.println(largestOddNumberInString(s));
    }
    static String largestOddNumberInString(String s)
    {
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i) %2 != 0)
            {
                return s.substring(0, i+1);
            }
        }
        return "";
    }

}
