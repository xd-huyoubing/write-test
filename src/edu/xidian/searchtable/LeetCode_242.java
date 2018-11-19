package edu.xidian.searchtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_242 {
    /**
     * 方式一：使用哈希表存储s中的每一个字符并统计其出现的次数
     * 遍历t,对其中的每一个字符在hash表中查找，如果存在，将其次数-1并判断次数是否小于等于0  若是则返回false
     * 若t中的字符在哈希表中不存在  直接返回false
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                Integer count = map.get(t.charAt(i));
                map.put(t.charAt(i), count - 1);
                if (count <= 0)
                    return false;
            } else
                return false;
        }
        return true;
    }

    /**
     * 因为字符为小写字母，所以直接统计在两个字符数组中字符出现的次数，一旦次数不相等则直接返回false
     *
     * @param
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arrS[s.charAt(i) - 97]++;
            arrT[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (arrS[i] != arrT[i])
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "aacc", t = "ccac";
        LeetCode_242 leetCode242 = new LeetCode_242();
        boolean anagram = leetCode242.isAnagram(s, t);
        System.out.println(anagram);
    }
}
