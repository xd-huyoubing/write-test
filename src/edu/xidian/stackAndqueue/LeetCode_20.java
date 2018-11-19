package edu.xidian.stackAndqueue;

import java.util.Stack;

/**
 * @auther huyoubing
 * @date 2018/11/6 16:23
 * 思路：使用一个栈保存左括号，遇到右括号则弹出栈顶，看是否和左括号匹配，若不匹配则直接返回false
 * 否则一直判断，一直到栈为空且字符串没有了  则返回true
 */
public class LeetCode_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c == '{' && s.charAt(i) != '}')
                    return false;
                else if (c == '[' && s.charAt(i) != ']')
                    return false;
                if (c == '(' && s.charAt(i) != ')')
                    return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "()";
        LeetCode_20 leetCode_20 = new LeetCode_20();
        boolean valid = leetCode_20.isValid(s);
        System.out.println(valid);

    }
}
