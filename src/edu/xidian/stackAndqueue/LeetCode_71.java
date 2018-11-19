package edu.xidian.stackAndqueue;

import java.util.Stack;

/**
 * @auther huyoubing
 * @date 2018/11/6 21:30
 */
public class LeetCode_71 {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        LeetCode_71 leetCode_71 = new LeetCode_71();
        String s = leetCode_71.simplifyPath(path);
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("") || split[i].equals("."))
                continue;
            else if (split[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(split[i]);
        }
        if (stack.isEmpty())
            return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String pop = "/" + stack.pop();
            sb.insert(0, pop);
        }
        return sb.toString();
    }
}
