package edu.xidian.searchtable;

import java.util.*;

public class LeetCode_451 {

    /**
     * 难点在于对map中的值进行排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }


        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aabbcddd";
        LeetCode_451 leetCode = new LeetCode_451();
        String s1 = leetCode.frequencySort(s);
        System.out.println(s1);
    }
}
