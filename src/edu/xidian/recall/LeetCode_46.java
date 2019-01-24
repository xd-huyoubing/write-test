package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/15 10:45
 */
public class LeetCode_46 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] flag = null;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        flag = new boolean[nums.length];
        generatePermute(nums, 0, new ArrayList<>());
        return result;
    }

    private void generatePermute(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            result.add(p);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //判断当前的数是否在p中，不在才能使用，因为不能循环使用  也就是说当第i个元素没有在p中才进行
            if (!flag[i]) {
                p.add(nums[i]);
                flag[i] = true;
                generatePermute(nums, index + 1, p);
                p.remove(i);
                flag[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
       LeetCode_46 leetCode_46 = new LeetCode_46();
       int[] nums = {1,2,3};
        List<List<Integer>> permute = leetCode_46.permute(nums);
    }
}
