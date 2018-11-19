package edu.xidian.searchtable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_447 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            // 中存储 点i 到所有其他点的距离出现的频次
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int res1 = caculate(new int[]{points[i][0], points[i][1]}, new int[]{points[j][0], points[j][1]});
                    if (map.containsKey(res1))
                        map.put(res1, map.get(res1) + 1);
                    else
                        map.put(res1, 1);
                }
            }

            for (Integer key : map.keySet()) {
                res += map.get(key) * (map.get(key) - 1);
            }
        }



        return res;
    }


    /**
     * 暴力解法   O(n^3)
     *
     * @param points
     * @return
     */
    public int numberOfBoomerangs1(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i)
                    continue;
                int res1 = caculate(new int[]{points[i][0], points[i][1]}, new int[]{points[j][0], points[j][1]});
                for (int k = 0; k < points.length; k++) {
                    if (k == j || k == i)
                        continue;
                    int res2 = caculate(new int[]{points[i][0], points[i][1]}, new int[]{points[k][0], points[k][1]});
                    if (res1 == res2)
                        count++;
                }
            }
        }
        return count;
    }

    private int caculate(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        LeetCode_447 leetCode = new LeetCode_447();

        int count = leetCode.numberOfBoomerangs(points);
        System.out.println(count);
    }
}
