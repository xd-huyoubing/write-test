package edu.xidian.searchtable;

public class LeetCode_16 {
    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[k] + nums[i] + nums[j];
                    if (target > 0) {
                        int res = temp - target;
                        if (Math.abs(res) < sum)
                            sum = temp;
                    } else {
                        int res = temp + target;
                        if (res < sum)
                            sum = temp;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        LeetCode_16 leetCode16 = new LeetCode_16();
        int i = leetCode16.threeSumClosest(nums, target);
        System.out.println(i);
    }
}
