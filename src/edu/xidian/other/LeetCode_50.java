package edu.xidian.other;

/**
 * @auther huyoubing
 * @date 2018/11/13 11:09
 */
public class LeetCode_50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        LeetCode_50 leetCode98 = new LeetCode_50();
        double v = leetCode98.myPow(2.00000, -2147483648);
        System.out.println(v);
    }
}
