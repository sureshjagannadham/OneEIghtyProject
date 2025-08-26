package basic_strings_i4;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242E
{
    public static void main(String[] args)
    {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram(s,t));
    }
    static boolean validAnagram(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            // Count characters in s
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);

        }
        for(int i=0; i<t.length(); i++)
        {
            if(!hm.containsKey(t.charAt(i)))
                return false;
            hm.put(t.charAt(i), hm.get(t.charAt(i))-1);
            if(hm.get(t.charAt(i)) < 0)
                return false;
        }
        return true;
    }

}
