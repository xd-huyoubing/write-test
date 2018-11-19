package edu.xidian.searchtable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i)//注意不能等于自己本身，这样就重复了两次
                return new int[]{i, map.get(res)};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        LeetCode_1 leetCode1 = new LeetCode_1();
        int[] ints = leetCode1.twoSum(nums, target);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }
}
