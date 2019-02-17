package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:48
 */
public class LeetCode_78 {
    private List<List<Integer>> res = new ArrayList<>();

    private void findSubsets(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);

            findSubsets(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
        return;
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        findSubsets(nums,0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        LeetCode_78 leetCode_78 = new LeetCode_78();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = leetCode_78.subsets(nums);
        System.out.println(subsets);
    }
}
