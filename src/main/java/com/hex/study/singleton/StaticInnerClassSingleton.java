package com.hex.study.singleton;

/**
 * 静态内部类
 1、单例类只能有一个实例。
 2、单例类必须自己创建自己的唯一实例。
 3、单例类必须给所有其他对象提供这一实例。
 *
 * @author hui.zhu
 */
public class StaticInnerClassSingleton {
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
    }

    public static final StaticInnerClassSingleton getInstance() {
        return SingletonHolder.singleton;
    }

    public void show(String userName) {
        System.out.println(userName + "擅长跳远");
    }
}
