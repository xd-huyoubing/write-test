package edu.xidian.searchtable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Character c = map.get(s.charAt(i));
                if (!c.equals(t.charAt(i)))
                    return false;
            } else {
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "ab", t = "aa";
//        String s = "foo", t = "bar";
        String s = "egg", t = "add";
        LeetCode_205 leetCode = new LeetCode_205();
        boolean anagram = leetCode.isIsomorphic(s, t);
        System.out.println(anagram);
    }
}
