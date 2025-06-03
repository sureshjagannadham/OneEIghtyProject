public class ReverseWordsinString151M
{
    public static void main(String[] args)
    {
        System.out.println(reverseWords("the sky is blue"));
    }

    static String reverseWords(String s)
    {
        String[] words = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--)
        {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
