package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 有兵
 * @date 2018/12/12 15:38
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，
 * 而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 */
public class LeetCode_417 {
    private List<int[]> res = new ArrayList<>();

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null) {
            return res;
        }


        return res;
    }
}
