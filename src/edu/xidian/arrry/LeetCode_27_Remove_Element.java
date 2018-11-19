package edu.xidian.arrry;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class LeetCode_27_Remove_Element {

    /**
     * 方式2：定义一个变量index表示[0...index]表示不等于val的区间
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
       int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    /**
     * 方法1：定义两个指针，一个指针指向[0...i]表示不等于val的值，一个指针[r...arr.length-1]表示等于val
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int r = nums.length - 1, i = 0;
        while (i <= r) {
            if (nums[i] != val) {
                i++;
            }
            else {
                swap(nums, i, r--);
            }
        }
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int i = new LeetCode_27_Remove_Element().removeElement2(nums, 2);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}
