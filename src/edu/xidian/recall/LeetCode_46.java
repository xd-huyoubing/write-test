package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/15 10:45
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 */
public class LeetCode_46 {
    static int length = 0;
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used = null;

    //在nums中寻找一个排列，当前已经找到了index-1个数字的排列保存在list中
    //正在寻找index这个数字的排列
    private void findNums(int[] nums, int index, List<Integer> list) {
        //找到了一个排列，将其保存在结果数组中  也是递归终止的条件
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
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
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return res;
        }
        used = new boolean[nums.length];
        findNums(nums, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        LeetCode_46 leetCode_46 = new LeetCode_46();

        int[] nums = {1, 2, 3};
        length = nums.length;
        leetCode_46.used = new boolean[length];
        for (int i = 0; i < leetCode_46.used.length; i++) {
            leetCode_46.used[i] = false;
        }
        List<List<Integer>> permute = leetCode_46.permute(nums);
        System.out.println(leetCode_46.res);
    }
}
