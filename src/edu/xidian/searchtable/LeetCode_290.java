package edu.xidian.searchtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 以pattern的每一个字符为键，str的每一个单词为值建立哈希表
 * 如果表中存在这个键，并且这个键的值和当前键的值相等，则进行下一个字符的判断
 * 如果表中没有这个键，单存在这个值，则直接返回false
 */
public class LeetCode_290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] split = str.split(" ");
        if (split.length != pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String s = map.get(c);
                if (!s.equals(split[i]))
                    return false;
            } else if (map.containsValue(split[i])) {
                return false;

            } else
                map.put(c, split[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        LeetCode_290 leetCode290 = new LeetCode_290();
        boolean result = leetCode290.wordPattern(pattern, str);

        System.out.println(result);
    }
}
