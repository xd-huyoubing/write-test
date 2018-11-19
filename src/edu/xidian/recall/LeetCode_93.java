package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/15 10:40
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class LeetCode_93 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0)
            return result;


        return null;
    }

    private void findIpAddresses(String s, int index, String res) {


    }

    public static void main(String[] args) {
        String s = "25525511135";
        LeetCode_93 leetCode_93 = new LeetCode_93();
        List<String> list = leetCode_93.restoreIpAddresses(s);
        System.out.println(list);
    }
}
