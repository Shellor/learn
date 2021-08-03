package com.hex.study.singleton;

/**
 * 枚举单例
 *
 * @author hui.zhu
 */
public enum EnumSingleton {
    SINGLETON;
    public void show(String userName) {
        System.out.println(userName + "擅长运动");
    }
}
