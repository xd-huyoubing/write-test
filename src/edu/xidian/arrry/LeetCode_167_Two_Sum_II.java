package edu.xidian.arrry;

public class LeetCode_167_Two_Sum_II {
    /**
     * 对撞指针实现   还可以使用二分查找法进行查找
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target)
                return new int[]{l + 1, r + 1};
            else if (numbers[l] + numbers[r] > target)
                r--;
            else
                l++;
        }
        return new int[]{-1, -1};
    }

}
