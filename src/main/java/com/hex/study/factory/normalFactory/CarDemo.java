package com.hex.study.factory.normalFactory;


/**
 * @author hui.zhu
 */
public class CarDemo {
    public static void main(String[] args) {
        BrandFactory brandFactory = new BrandFactory();
        createCar(brandFactory, "bmw");
        createCar(brandFactory, "benz");
        createCar(brandFactory, "audi");
    }

    private static void createCar(BrandFactory brandFactory, String brand) {
        Brand carBrand = brandFactory.getBrand(brand);
        if (carBrand != null) {
            carBrand.create();
        } else {
            System.out.println("none " + brand + " brand");
        }
    }
}