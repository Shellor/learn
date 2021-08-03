package com.hex.study.factory.normalFactory;


import com.hex.study.factory.normalFactory.impl.BMW;
import com.hex.study.factory.normalFactory.impl.Benz;

/**
 * @author hui.zhu
 */
public class BrandFactory {
    public Brand getBrand(String brand) {
        if ("bmw".equals(brand)) {
            return new BMW();
        } else if("benz".equals(brand)) {
            return new Benz();
        }
        return null;
    }
}
