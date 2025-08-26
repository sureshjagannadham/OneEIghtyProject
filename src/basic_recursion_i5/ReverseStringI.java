package basic_recursion_i5;

public class ReverseStringI
{
    public static void main(String[] args)
    {
        String s = "hello";
        System.out.println(revers(s, s.length()-1));
    }
    static String revers(String s, int index)
    {
        if(index < 0)
            return "";
        return s.charAt(index)+ revers(s, index-1);
    }
}
