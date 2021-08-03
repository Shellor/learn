package com.hex.study.singleton;

/**
 * 双重校验
 1、单例类只能有一个实例。
 2、单例类必须自己创建自己的唯一实例。
 3、单例类必须给所有其他对象提供这一实例。
 *
 * @author hui.zhu
 */
public class DoubleCheckedSingleton {
    private volatile static DoubleCheckedSingleton doubleCheckedSingleton;

    private DoubleCheckedSingleton() {
    }

    /**
     * Lazy初始化
     * 支持多线程，在多线程情况下能保持高性能
     * @return
     */
    public static DoubleCheckedSingleton getInstance() {
        if (doubleCheckedSingleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (doubleCheckedSingleton == null) {
                    doubleCheckedSingleton = new DoubleCheckedSingleton();
                }
            }
        }
        return doubleCheckedSingleton;
    }

    public void show(String userName) {
        System.out.println(userName + "擅长跳远");
    }
}
