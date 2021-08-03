package com.hex.study.singleton;

/**
 * @author hui.zhu
 */
public class SingletonDemo {
    public static void main(String[] args) {
        //public可用构造函数SimpleSingleton()
        //private 构造函数SimpleSingleton()不可见
//        SimpleSingleton simpleSingleton = new SimpleSingleton();
        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
        simpleSingleton.show("Shellor");

        /*LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.show("Tom");
        lazySingleton = LazySingleton.getLazySingleton();
        lazySingleton.show("Jerry");*/

        LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
        lazySingleton1.show("David");
        lazySingleton1 = LazySingleton.getInstance();
        lazySingleton1.show("Lily");

        DoubleCheckedSingleton doubleCheckedSingleton = DoubleCheckedSingleton.getInstance();
        doubleCheckedSingleton.show("Tom1");
        doubleCheckedSingleton.show("Tom2");
        doubleCheckedSingleton.show("Tom3");
        doubleCheckedSingleton.show("Tom4");

        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
        staticInnerClassSingleton.show("Tom5");

        EnumSingleton.SINGLETON.show("张三");
    }
}
