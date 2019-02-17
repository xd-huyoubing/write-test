package edu.xidian.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:44
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 *
 *
 * 使用回溯法   但是注意每一个数能多次使用 ，因此需要重复计算  如果小于target则返回
 */
public class LeetCode_39 {
    private List<List<Integer>> res = new ArrayList<>();

    private void findCombinationSum(int[] candidates, int target, int start, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            //特别注意此处出入i,因为可以重复计算
            findCombinationSum(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        findCombinationSum(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        LeetCode_39 l = new LeetCode_39();
        l.combinationSum(candidates, target);
        System.out.println(l.res);
    }
}
