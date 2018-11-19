package edu.xidian.arrry;

public class LeetCode_75_Sort_Colors {

    /**
     * 三路快排的思路可以实现遍历一次就排序
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {

    }

    /**
     * 方法一：统计出0，1，2三个元素的个数即可，然后对每一个元素的个数进行赋值，两次循环O(n)的时间复杂度
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < arr[0])
                nums[i] = 0;
            else if (i - arr[0] < arr[1])
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        LeetCode_75_Sort_Colors rest = new LeetCode_75_Sort_Colors();

        rest.sortColors(nums);
    }
}
