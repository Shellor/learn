package com.hex.study.factory.abstractFactory.factory;

import com.hex.study.factory.abstractFactory.Brand;
import com.hex.study.factory.abstractFactory.Color;
import com.hex.study.factory.abstractFactory.impl.brand.BMW;
import com.hex.study.factory.abstractFactory.impl.brand.Benz;

/**
 * @author hui.zhu
 */
public class BrandFactory extends CarFactory {
    public Brand getBrand(String brand) {
        if ("bmw".equals(brand)) {
            return new BMW();
        } else if("benz".equals(brand)) {
            return new Benz();
        }
        return null;
    }

    public Color getColor(String color) {
        return null;
    }
}
