package edu.xidian.arrry;

public class LeetCode_209_Minimum_Size_Subarray_Sum {
    /**
     * 使用滑动窗口解法，时间复杂度为O(n)
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;//在[l...r]这个滑动窗口上寻找 和大于等于 目标s的连续子数组,开始的时候窗口中没有值
        int len = nums.length + 1;  //记录最小的连续子数组的长度
        int sum = 0;                //记录滑动窗口中的数组的和

        //滑动窗口的左边界小于数组的长度表明这个滑动窗口存在 所有还得找
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];

            //如果新的窗口的和大于等于s则找到一个和
            if (sum >= s)
                len = Math.min(r - l + 1, len);
        }
        return len == nums.length + 1 ? 0 : len;
    }

    /**
     * 暴力解法   时间复杂度为O(n^2)
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    len = Math.min(len, j - i + 1);
                    break;
                }
            }
            sum = 0;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int s = 11;
        LeetCode_209_Minimum_Size_Subarray_Sum subarraySum = new LeetCode_209_Minimum_Size_Subarray_Sum();
        int res = subarraySum.minSubArrayLen1(s, nums);

        System.out.println(res);
    }
}
