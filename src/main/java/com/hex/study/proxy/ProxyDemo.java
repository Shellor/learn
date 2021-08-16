package com.hex.study.proxy;

/**
 * @author hui.zhu
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("student.png");
        image.disPlay();
        System.out.println();
        image.disPlay();
    }
}
