package edu.xidian.searchtable;

import java.util.*;

public class LeetCode_18 {

    /**
     * 四数之和与三数之和一样，多一层循环而已，注意需要判断重复元素
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4 || nums == null)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                //
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1, right = nums.length - 1;
                while (left < right) {

                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        left++;
                        right--;
                        result.add(list);
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (temp < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        LeetCode_18 leetCode = new LeetCode_18();
        List<List<Integer>> lists = leetCode.fourSum(nums, target);

        System.out.println(lists);
    }
}
