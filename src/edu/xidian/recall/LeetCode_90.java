package edu.xidian.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:48
 */
public class LeetCode_90 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        findSubsetsWithDup(nums, 0, new ArrayList<>());
        return res;
    }

    private void findSubsetsWithDup(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            findSubsetsWithDup(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
        return;
    }
    public static void main(String[] args) {
        LeetCode_90 leetCode = new LeetCode_90();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = leetCode.subsetsWithDup(nums);
        System.out.println(subsets);
    }
}
