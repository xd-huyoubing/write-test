package edu.xidian.arrry;

/**
 * @author 有兵
 */
public class LeetCode_11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        return 0;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        LeetCode_11_Container_With_Most_Water leetCode11ContainerWithMostWater = new LeetCode_11_Container_With_Most_Water();
        int maxArea = leetCode11ContainerWithMostWater.maxArea(height);
        System.out.println(maxArea);
    }
}
