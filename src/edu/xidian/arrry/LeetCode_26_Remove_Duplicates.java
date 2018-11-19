package edu.xidian.arrry;

public class LeetCode_26_Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        else if (nums.length == 1)
            return 1;
        int index = 0, i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[index])
                i++;
            else
                nums[++index] = nums[i++];
        }

        return index + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int i = new LeetCode_26_Remove_Duplicates().removeDuplicates(nums);
        System.out.println(i);
    }

}
