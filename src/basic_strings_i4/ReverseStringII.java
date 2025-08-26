package basic_strings_i4;

public class ReverseStringII
{
    public static void main(String[] args)
    {
        String s = "abcdefg";
        int k = 2;
        String ans = reverseStringII(s, k);
        System.out.println(ans);
    }

    static String reverseStringII(String s, int k)
    {
        char[] arr = s.toCharArray();
        for(int start =0; start< arr.length; start+=2*k)
        {
            int i= start;
            int j= Math.min(start+k-1, arr.length-1);
            while(i <j)
            {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
