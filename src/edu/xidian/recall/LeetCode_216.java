package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:47
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合
 */
public class LeetCode_216 {
    private List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || k <= 0) {
            return res;
        }
        findCombinationSum3(k, n, new ArrayList<Integer>(),1);
        return res;
    }

    private void findCombinationSum3(int k, int n, List<Integer> list,int start) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9 && n >= 0; i++) {
            list.add(i);
            findCombinationSum3(k, n - i, list,i+1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode_216 l = new LeetCode_216();
        int k = 3, n = 9;
        l.combinationSum3(k,n);
        System.out.println(l.res);
    }
}
