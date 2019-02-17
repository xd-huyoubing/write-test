package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:27
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class LeetCode_77 {
    private List<List<Integer>> res = new ArrayList<>();

    //求解C(n,k),当前已经找到的元素存放在list中，需要从start开始搜索新的元素
    private void findCombine(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n-(k-list.size())+1; i++) {
            list.add(i);
            findCombine(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
        return;
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || n < k || k < 0) {
            return res;
        }
        findCombine(n, k, 1, new ArrayList<>());
        return res;
    }
}
