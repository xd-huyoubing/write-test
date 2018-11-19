package edu.xidian.searchtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_15 {

    /**
     * 三数之和的思路：
     * 1. 首先对数组进行排序，然后使用指针对撞的方式进行查找
     * 2. 在查找过程中需要对重复元素进行判断，如果元素重复了则需要跳过。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3 || nums == null)
            return result;

        //对数组进行排序
        Arrays.sort(nums);

        //-4,-1,-1,0,1,2
        for (int i = 0; i < nums.length - 2; i++) {
            //若 nums[i]>0，则此时一定不存在三个数相加和为0，因为数组已经排序了并且两个指针的位置在i的右侧
            if (nums[i] > 0)
                break;
            int l = i + 1, r = nums.length - 1;

            //对当前i进行判断，如果前一个元素和当前元素一样，则在i-1的时候已经处理过了 因此需要跳过这个元素
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;

                    //若此时左指针重复，则需要跳过
                    while (l < r && nums[l] == nums[l - 1])
                        l++;

                    //若此时右指针重复，则需要跳过
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

    /**
     * 暴力解法   timeout O(n^3)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (!result.contains(list))
                            result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        LeetCode_15 leetCode = new LeetCode_15();
        List<List<Integer>> lists = leetCode.threeSum(nums);

        System.out.println(lists);
    }
}
