package edu.xidian.arrry;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class LeetCode283_Move_Zeroes {

    /**
     * 方式1：可以使用一个辅助数组
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public void moveZeroes1(int[] nums) {
        int[] help = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                help[k++] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = help[i];
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }


    }


    /**
     * 方式2：两个指针可以解决
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        /*int index = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0)
                swap(nums, ++index, k);
        }*/

        int index = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0)
                swap(nums, index++, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        new LeetCode283_Move_Zeroes().moveZeroes1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
