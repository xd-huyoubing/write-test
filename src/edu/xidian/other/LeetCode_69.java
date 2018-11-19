package edu.xidian.other;

/**
 * @auther huyoubing
 * @date 2018/11/13 11:10
 */
public class LeetCode_69 {
    public int mySqrt(int x) {
        int i = 0, j = x / 2 + 1;
        int mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            int temp = mid * mid;
            if (temp == x)
                return mid;
            if (temp < x)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return j;
    }

    public static void main(String[] args) {
        LeetCode_69 leetCode_69 = new LeetCode_69();
        int i = leetCode_69.mySqrt(8);
        System.out.println(i);
    }
}
