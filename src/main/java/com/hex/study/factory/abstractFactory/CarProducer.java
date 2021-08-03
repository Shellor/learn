package com.hex.study.factory.abstractFactory;

import com.hex.study.factory.abstractFactory.factory.BrandFactory;
import com.hex.study.factory.abstractFactory.factory.CarFactory;
import com.hex.study.factory.abstractFactory.factory.ColorFactory;

/**
 * @author hui.zhu
 */
public class CarProducer {
    public static CarFactory getFactory(String choice){
        if("BRAND".equals(choice)){
            return new BrandFactory();
        } else if("COLOR".equals(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
