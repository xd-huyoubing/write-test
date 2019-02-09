package edu.xidian.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/15 10:40
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 */
public class LeetCode_131 {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0 || s == null) {
            return res;
        }
        partition(s, 0, new LinkedList<>());
        return res;
    }

    private void partition(String s, int index, LinkedList<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                partition(s, i + 1, list);
                list.removeLast();
            }
        }
    }

    //判断一个字符串是否是回文数
    private boolean isPalindrome(String str, int l, int r) {
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l++;
            r--;
        }

        return l >= r;
    }

    public static void main(String[] args) {
        LeetCode_131 leetCode_131 = new LeetCode_131();
        List<List<String>> aab = leetCode_131.partition("aab");
        System.out.println(aab);
    }
}
