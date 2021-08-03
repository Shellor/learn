package com.hex.study.factory.normalFactory.impl;

import com.hex.study.factory.normalFactory.Brand;

/**
 * @author hui.zhu
 */
public class BMW implements Brand {
    public void create() {
        System.out.println("create a BMW");
    }
}
