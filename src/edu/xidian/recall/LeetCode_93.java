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
        if (s.length() <= 0 || s.length() > 12) {
            return result;
        }

        findIpAddresses(s, 0, new String());
        return result;

    }

    /**
     * s为需要处理的字符串，dotNums为小数点的个数最多三个，开始为0
     */

    private void findIpAddresses(String s, int dotNums, String res) {
        //递归终止条件
        if (dotNums == 3) {
            //加入剩下的字符串不止一位但是第一位还是0，则无意义  所有需要派出
            //同时如果剩下的数大于255也不是一个合法的IP地址
            if (s.length() > 1 && s.charAt(0) == '0' || Integer.parseInt(s) > 255) {
                return;
            }
            result.add(res + "." + s);
        }

        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(0, i);
            //当前段小于256，表示合法，可以继续
            if (Integer.parseInt(temp) < 256) {
                String resNext = s.substring(i);
                if (res.length() > 0) {
                    temp = res + "." + temp;
                }
                findIpAddresses(resNext, dotNums + 1, temp);
                if (s.charAt(0) == '0') {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "0279245587303";
        LeetCode_93 leetCode_93 = new LeetCode_93();
        List<String> list = leetCode_93.restoreIpAddresses(s);
        System.out.println(list);
    }
}
