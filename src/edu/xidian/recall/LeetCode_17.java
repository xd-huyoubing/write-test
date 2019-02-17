package edu.xidian.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/12 21:18
 * <p>
 * 递归与回溯法
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */


public class LeetCode_17 {
    private static String[] digitsMap = {
            " ", //0
            "", //1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz",//9
    };
    private static List<String> res = new LinkedList<>();

    private void findDigits(String digits, int index, String str) {
        if (index == digits.length()) {
            res.add(new String(str));
            return;
        }
        //获取到这个数字 并获取这个数字对应的字符串
        char c = digits.charAt(index);
        String tempStr = digitsMap[c - '0'];

        //将每一个数字遍历
        for (int i = 0; i < tempStr.length(); i++) {
            findDigits(digits, index + 1, str + tempStr.charAt(i));
        }
        return;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        findDigits(digits, 0, new String());
        return res;
    }

    public static void main(String[] args) {
        LeetCode_17 leetCode_17 = new LeetCode_17();
        leetCode_17.letterCombinations("");
        System.out.println(res);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
