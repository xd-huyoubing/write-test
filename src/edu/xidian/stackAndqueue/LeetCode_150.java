package edu.xidian.stackAndqueue;

import java.util.Stack;

/**
 * @auther huyoubing
 * @date 2018/11/6 21:16
 * <p>
 * 思路：如果遇到的字符不是四个运算符号，则将这个字符保存在栈中，一旦遇到符号，就在栈中弹出两个数字进行操作。
 * 注意减法和除法，入栈是正序，但出栈是逆序，因此需要反过来才行
 */
public class LeetCode_150 {
    public static void main(String[] args) {
        String[] tokens = {"0", "3", "/"};
        LeetCode_150 leetCode_150 = new LeetCode_150();
        int i = leetCode_150.evalRPN(tokens);
        System.out.println(i);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
