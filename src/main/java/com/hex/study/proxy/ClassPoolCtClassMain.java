package com.hex.study.proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

import java.io.FileOutputStream;

/**
 * @author hui.zhu
 */
public class ClassPoolCtClassMain {
    public static void main1(String[] args) {
        //默认的类搜索路径
        ClassPool pool = ClassPool.getDefault();
        //获取一个ctClass对象
        CtClass ctClass = pool.makeClass("com.hui.study");
        try {
            //添加age属性
            ctClass.addField(CtField.make("private int age;", ctClass));
            //添加setAge方法
            ctClass.addMethod(CtMethod.make("public void setAge(int age){this.age = age;}", ctClass));
            //添加getAge方法
            ctClass.addMethod(CtMethod.make("public int getAge(){return this.age;}", ctClass));
            //将ctClass生成字节数组，并写入文件
            byte[] byteArray = ctClass.toBytecode();
            FileOutputStream output = new FileOutputStream("C:\\Users\\31263\\Desktop\\hui\\study/study.class");
            output.write(byteArray);
            output.close();
            System.out.println("文件写入成功!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.hui.student");
        /*ClassPool.doPruning被设置成true，Javassist会在冻结一个对象的时候对这个对象进行精简，被精简的CtClass对象不能够再被defrost*/
//        ClassPool.doPruning = true;
//        ctClass.stopPruning(true);
        try {
            //添加属性
            ctClass.addField(CtField.make("private int age;", ctClass));
            //添加setAge方法
            ctClass.addMethod(CtMethod.make("public void setAge(int age){this.age = age;}", ctClass));
            ctClass.addMethod(CtMethod.make("public int getAge(){return this.age;}", ctClass));

            byte[] byteArray = ctClass.toBytecode();
            FileOutputStream output = new FileOutputStream("C:\\Users\\31263\\Desktop\\hui\\study/student.class");
            output.write(byteArray);
            output.close();
            System.out.println("文件生成成功!!!");

            /*如果一个CtClass对象通过writeFile()，toClass()或者toBytecode()转换成了class文件，
            那么Javassist会冻结这个CtClass对象。后面就不能继续修改这个CtClass对象了。
            这样是为了警告开发者不要修改已经被JVM加载的class文件，因为JVM不允许重新加载一个类。ctClass.addField*/
            if(ctClass.isFrozen()){
                ctClass.defrost();
            }

            //这里用pool.get()去获取ctClass对象，表示默认JVM已经加载此类.
            ctClass = pool.get("com.hui.student");
            // 获取getAge方法
            CtMethod ctMethod = ctClass.getDeclaredMethod("getAge");
            // 在方法的代码后追加 一段代码
            ctMethod.insertAfter("System.out.println(\"I'm \" + 20 + \" years old.\");");
            ctClass.addField(CtField.make("private String sex;", ctClass));
            ctClass.addMethod(CtMethod.make("public void setSex(String sex){this.sex = sex;}", ctClass));
            ctClass.addMethod(CtMethod.make("public String getSex(){return this.sex;}", ctClass));
            ctClass.addField(CtField.make("private String name;", ctClass));
            ctClass.addMethod(CtMethod.make("public void setName(String name){this.name = name;}", ctClass));
            ctClass.addMethod(CtMethod.make("public String getName(){return this.name;}", ctClass));

            byteArray = ctClass.toBytecode();
            output = new FileOutputStream("C:\\Users\\31263\\Desktop\\hui\\study/student.class");
            output.write(byteArray);
            output.close();

            System.out.println("文件修改成功!!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
