package edu.xidian.singleton;

/**
 * @author 有兵
 * @date 2019/2/16 11:50
 */
public class Main {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.INSTANCE;
        System.out.println(singleton1);

        Singleton2 singleton2 = Singleton2.INSTANCE;
        System.out.println(singleton2);

        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3);
    }
}
