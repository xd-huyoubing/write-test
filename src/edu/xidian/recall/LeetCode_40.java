package edu.xidian.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:45
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class LeetCode_40 {
    private List<List<Integer>> res = new ArrayList<>();
    //private boolean[] used = null;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0 || candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        //used = new boolean[candidates.length];
        findCombinationSum2(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void findCombinationSum2(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            list.add(candidates[i]);
            findCombinationSum2(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        //int[] candidates = { 2,5,2,1,2};
        int target = 8;
        LeetCode_40 l = new LeetCode_40();
        l.combinationSum2(candidates, target);
        System.out.println(l.res);

    }
}
