package basic_strings_i4;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205E
{
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isomorphicStrings(s, t));
    }
    static boolean isomorphicStrings(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            if(hm.containsKey(s.charAt(i)))
            {
                if(!hm.get(s.charAt(i)).equals(t.charAt(i)) )
                    return false;
            }
            else
            {
                if(hm.containsValue(t.charAt(i)))
                {
                    return false;
                }
                else {

                    hm.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }
}
