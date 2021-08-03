package com.hex.study.factory.abstractFactory;

import com.hex.study.factory.abstractFactory.factory.CarFactory;

/**
 * @author hui.zhu
 */
public class CarDemo {
    public static void main(String[] args) {
        CarFactory brandFactory = CarProducer.getFactory("BRAND");
        createCar(brandFactory, "bmw");
        createCar(brandFactory, "benz");
        createCar(brandFactory, "audi");
        CarFactory colorFactory = CarProducer.getFactory("COLOR");
        fillColor(colorFactory, "red");
        fillColor(colorFactory, "blue");
        fillColor(colorFactory, "black");
        fillColor(colorFactory, "white");
    }

    private static void createCar(CarFactory brandFactory, String brand) {
        Brand carBrand = brandFactory.getBrand(brand);
        if (carBrand != null) {
            carBrand.create();
        } else {
            System.out.println("none " + brand + " brand");
        }
    }

    private static void fillColor(CarFactory colorFactory, String color) {
        Color carColor = colorFactory.getColor(color);
        if (carColor != null) {
            carColor.fill();
        } else {
            System.out.println("none " + color);
        }
    }
}