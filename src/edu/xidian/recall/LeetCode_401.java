package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:49
 */
public class LeetCode_401 {
     public List<String> readBinaryWatch(int num) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 12; i++) {
                    for (int j = 0; j < 60; j++) {
                //1的个数等于输入的num的个数 找到一个时间
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    list.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LeetCode_401 leetCode_401 = new LeetCode_401();
        List<String> strings = leetCode_401.readBinaryWatch(1);
        System.out.println(strings);
    }
}
