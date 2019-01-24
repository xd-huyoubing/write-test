package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/12 21:18
 * <p>
 * 递归与回溯法
 */
public class LeetCode_17 {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        findCombinations(digits, 0, "");
        return result;
    }

    private void findCombinations(String digits, int index, String s) {

        //递归结束的条件，输入的字符串处理完了，此时保存找到的一个字符串
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        //获取每一个数字对应的字符串
        String letters = getLetters(digits.charAt(index) - '0');
        for (int i = 0; i < letters.length(); i++) {
            findCombinations(digits, index + 1, s + letters.charAt(i));
        }
    }

    private String getLetters(int index) {
        String[] str = {
                //0
                " ",
                //1
                "",
                //2
                "abc",
                //3
                "def",
                //4
                "ghi",
                //5
                "jkl",
                //6
                "mno",
                //7
                "pqrs",
                //8
                "tuv",
                //9
                "wxyz"
        };
        return str[index];
    }

    public static void main(String[] args) {
        LeetCode_17 leetCode_17 = new LeetCode_17();
        String digits = "234";
        List<String> strings = leetCode_17.letterCombinations(digits);
        System.out.println(strings);
    }
}
