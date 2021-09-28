package com.hex.study.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock实现按顺序执行
 *
 * @author hui.zhu
 */
public class ReentrantLockForOrder {
    private static final Logger log = LoggerFactory.getLogger(ReentrantLockForOrder.class);
    
    private static final int START = 100;
    public static void main(String[] args) {
        final ThreeThread threeThread = new ThreeThread();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (threeThread.start > START) {
                            System.out.println("A线程结束");
                            break;
                        }
                        threeThread.printA();
                    } catch (InterruptedException e) {
                        log.error("A线程执行异常", e);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (threeThread.start > START) {
                            System.out.println("B线程结束");
                            break;
                        }
                        threeThread.printB();
                    } catch (InterruptedException e) {
                        log.error("B线程执行异常", e);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (threeThread.start > START) {
                            System.out.println("C线程结束");
                            break;
                        }
                        threeThread.printC();
                    } catch (InterruptedException e) {
                        log.error("C线程执行异常", e);
                    }
                }
                System.out.println("线程全部执行完成");
            }
        }.start();
    }
}

class ThreeThread {
    private static final int START = 100;
    private ReentrantLock lock = new ReentrantLock();
    private Condition A = lock.newCondition();
    private Condition B = lock.newCondition();
    private Condition C = lock.newCondition();

    public static int start = 1;
    public int flag = 1;

    public void printA() throws InterruptedException {
        lock.lock();
        if (flag != 1) {
            A.await();
        }
        if (start > START) {
            B.signal();
            C.signal();
            lock.unlock();
            return;
        }
        System.out.println("A线程" + start++);
        flag = 2;

        B.signal();
        lock.unlock();
    }

    public void printB() throws InterruptedException {
        lock.lock();
        if (flag != 2) {
            B.await();
        }
        if (start > START) {
            A.signal();
            C.signal();
            lock.unlock();
            return;
        }
        System.out.println("B线程" + start++);
        flag = 3;

        C.signal();
        lock.unlock();
    }

    public void printC() throws InterruptedException {
        lock.lock();
        if (flag != 3) {
            C.await();
        }
        if (start > START) {
            A.signal();
            B.signal();
            lock.unlock();
            return;
        }
        System.out.println("C线程" + start++);
        flag = 1;

        A.signal();
        lock.unlock();
    }
}
