package edu.xidian.recall;

import java.util.*;

/**
 * @auther huyoubing
 * @date 2018/11/19 15:23
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class LeetCode_47 {
    private List<List<Integer>> res = new ArrayList<>();
    private Set<List<Integer>> set = new HashSet<>();
    private boolean[] used = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return res;
        }
        used = new boolean[nums.length];
        findNums(nums, 0, new LinkedList<>());

        for (List<Integer> list: set) {
            res.add(list);
        }

        return res;
    }

    private void findNums(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                findNums(nums, index + 1, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        LeetCode_47 leetCode_47 = new LeetCode_47();

        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = leetCode_47.permuteUnique(nums);
        System.out.println(lists);
        System.out.println(leetCode_47.res);

    }
}
