package com.hex.study.factory.abstractFactory.factory;

import com.hex.study.factory.abstractFactory.Brand;
import com.hex.study.factory.abstractFactory.Color;
import com.hex.study.factory.abstractFactory.impl.color.Black;
import com.hex.study.factory.abstractFactory.impl.color.Blue;
import com.hex.study.factory.abstractFactory.impl.color.Red;

/**
 * @author hui.zhu
 */
public class ColorFactory extends CarFactory {
    public Brand getBrand(String brand) {
        return null;
    }

    public Color getColor(String color) {
        if ("red".equals(color)) {
            return new Red();
        } else if ("blue".equals(color)) {
            return new Blue();
        } else if ("black".equals(color)) {
            return new Black();
        }
        return null;
    }
}
