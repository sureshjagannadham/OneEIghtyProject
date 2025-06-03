import java.util.Stack;

public class CheckBalancedParanthesis20E
{
    public static void main(String[] args)
    {
        String s = "({})[]";
        System.out.println(isValid(s));

    }

    static boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(char it :ch)
        {
            if(it == '(' || it == '{' || it == '[')
            {
                st.push(it);
            }
            else
            {
                if(st.isEmpty())
                    return false;
                char c = st.pop();
                if(it == ')' && c == '(' || it == '}' && c == '{' || it == ']' && c == '[')
                {
                   continue;
                }
                else
                    return false;
            }
        }
        // Return true if all brackets are matched, stack should be empty
        return st.isEmpty();
    }
}
