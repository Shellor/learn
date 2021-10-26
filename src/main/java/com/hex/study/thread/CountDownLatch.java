package com.hex.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author hui.zhu
 */
public class CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.calculate();

        Thread.sleep(1000);
    }

    private static final class Count extends AbstractQueuedSynchronizer {
        Count(int count) {
            setState(count);
        }

        int getCount() {
            return getState();
        }

        protected int acquireShared() {
            return (getState() == 0) ? 1 : -1;
        }

        protected boolean releaseShared() {
            int c = getState();
            if (c == 0) {
                return false;
            }
            int next = c - 1;
            if (compareAndSetState(c, next)) {
                return next == 0;
            }
            return true;
        }
    }

    private final Count count;

    public CountDownLatch(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        this.count = new Count(count);
    }

    public void await() throws InterruptedException {
        count.acquireShared();
    }

    public boolean await(long timeOut, TimeUnit unit)  throws InterruptedException {
        return count.tryAcquireSharedNanos(1, unit.toNanos(timeOut));
    }

    public void countDown() {
        count.releaseShared();
    }

    public long getCount() {
        return count.getCount();
    }
}

class CountDownLatchDemo {
    private CountDownLatch countDownLatch;

    private int start = 10;
    private int mid = 100;
    private int end = 200;

    private volatile int tmpRes1, tmpRes2;

    private int add(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }


    private int sum(int a, int b) {
        return a + b;
    }

    public void calculate() {
        countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    // 确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                    Thread.sleep(100);
                    System.out.println("thread1开始执行");
                    tmpRes1 = add(start, mid);
                    System.out.println(Thread.currentThread().getName() +
                            " : calculate ans: " + tmpRes1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    // 确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                    Thread.sleep(100);
                    System.out.println("thread2开始执行");
                    tmpRes2 = add(mid + 1, end);
                    System.out.println(Thread.currentThread().getName() +
                            " : calculate ans: " + tmpRes2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    // 确保线程3先与1，2执行，由于countDownLatch计数不为0而阻塞
                    System.out.println("thread3开始执行");
                    countDownLatch.await();
                    int ans = sum(tmpRes1, tmpRes2);
                    System.out.println(Thread.currentThread().getName() +
                            " : calculate ans: " + ans);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.calculate();

        Thread.sleep(1000);
    }
}
