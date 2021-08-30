package com.hex.study.thread;

import com.hex.study.strategy.impl.Add;

/**
 *synchronized实现线程安全
 *
 * @author hui.zhu
 */
public class AddSynchronized {
    public static void main(String[] args) {
        AddNumber add = new AddNumber();
        new Thread(add, "one").start();
        new Thread(add, "two").start();
        new Thread(add, "three").start();
        AddNumber01 addNumber01 = new AddNumber01();
        new Thread(addNumber01, "one").start();
        new Thread(addNumber01, "two").start();
        new Thread(addNumber01, "three").start();
    }
}

class AddNumber implements Runnable{
    private boolean flag = true;
    private int count = 0;

    public void run() {
        while (flag) {
            addNum();
        }
    }

    /**
     * 方法添加synchronized实现线程安全
     */
    private synchronized void addNum() {
        if (count >= 10) {
            flag = false;
            return;
        }
        //模拟网络延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count ++;
        System.out.println("AddNumber----" + Thread.currentThread().getName() + ":" + count);
    }
}

/**
 * 使用缩小的synchronized块 + double checking,使并发安全
 * 单例设计模式中有个double-checking
 */
class AddNumber01 implements Runnable {
    private int count = 0;
    private boolean flag = true;

    public void run() {
        while (flag) {
            addNum();
        }
    }

    private void addNum() {
        if (count >= 100) {
            flag = false;
            return;
        }
        /**
         * 方法快添加synchronized实现
         */
        synchronized (this) {
            /**
             * 当数据打到100时，多个线程走到这，如果不进行第2个if-checking，进程同步进行后就会出现 101
             */
            if (count >= 100) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++;
            System.out.println("AddNumber01----" + Thread.currentThread().getName() + ":" + count);
        }
    }
}
