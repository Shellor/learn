package com.hex.study.factory.abstractFactory.impl.brand;

import com.hex.study.factory.abstractFactory.Brand;

/**
 * @author hui.zhu
 */
public class Benz implements Brand {
    public void create() {
        System.out.println("create a Benz");
    }
}
