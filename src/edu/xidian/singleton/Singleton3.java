package edu.xidian.singleton;

/**
 * @author 有兵
 * @date 2019/2/16 11:48
 */
public class Singleton3 {
    private Singleton3() {
    }

    private static final Singleton3 instance;

    static {
        instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}