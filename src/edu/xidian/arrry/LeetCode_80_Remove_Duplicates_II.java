package edu.xidian.arrry;

public class LeetCode_80_Remove_Duplicates_II {
    public int removeDuplicates(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = new LeetCode_27_Remove_Element().removeElement2(nums, 2);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}
