package com.hex.study.singleton;

/**
 * 懒汉式
 1、单例类只能有一个实例。
 2、单例类必须自己创建自己的唯一实例。
 3、单例类必须给所有其他对象提供这一实例。
 *
 * @author hui.zhu
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    /**
     * Lazy初始化
     * 这种方式是最基本的实现方式，但不支持多线程
     * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式
     * @return
     */
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * Lazy 初始化
     * 这种方式具备很好的 lazy loading，支持多线程，但效率很低
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率
     * @return
     */
    public static synchronized LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public void show(String userName) {
        System.out.println(userName + "擅长跳远");
    }
}
