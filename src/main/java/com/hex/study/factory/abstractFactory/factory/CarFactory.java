package com.hex.study.factory.abstractFactory.factory;

import com.hex.study.factory.abstractFactory.Brand;
import com.hex.study.factory.abstractFactory.Color;

/**
 * 汽车抽象工厂
 *
 * @author hui.zhu
 */
public abstract class CarFactory {
    public abstract Brand getBrand(String brand);
    public abstract Color getColor(String color);
}
