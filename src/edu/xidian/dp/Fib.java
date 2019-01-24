package edu.xidian.dp;

/**
 * @author 有兵
 * @date 2018/12/13 9:23
 */
public class Fib {
    static int[] memo = new int[43];

    int num = 0;
    public int fib(int n) {
        num++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(memo[n] == -1){
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {

        for (int i = 0; i < 43; i++) {
            memo[i] = -1;
        }
        Fib fib = new Fib();
        long startTime = System.currentTimeMillis();
        int res = fib.fib(42);
        System.out.println(res);
        long endTime = System.currentTimeMillis();
        System.out.println("num: "+fib.num);
        System.out.println("Total time is :" + (endTime - startTime));
    }

}
