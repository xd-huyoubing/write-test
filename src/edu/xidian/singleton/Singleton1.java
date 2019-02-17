package edu.xidian.singleton;

/**
 * @author 有兵
 * @date 2019/2/16 11:46
 */
public class Singleton1 {
    private Singleton1() {

    }

    public static final Singleton1 INSTANCE = new Singleton1();
}
