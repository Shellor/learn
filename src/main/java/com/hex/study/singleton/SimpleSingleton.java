package com.hex.study.singleton;

/**
 * 一般单例
 1、单例类只能有一个实例。
 2、单例类必须自己创建自己的唯一实例。
 3、单例类必须给所有其他对象提供这一实例。
 *
 * @author hui.zhu
 */
public class SimpleSingleton {
    private static SimpleSingleton simpleSingleton = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return simpleSingleton;
    }

    public void show(String userName) {
        System.out.println(userName + "擅长跳远");
    }
}
