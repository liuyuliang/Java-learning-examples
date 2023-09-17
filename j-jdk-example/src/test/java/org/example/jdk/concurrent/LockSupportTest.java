package org.example.jdk.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * ClassName: LockSupport
 * Description：<pre>
 *     交替打印以下两个变量
 *      char[] aI = "1234567".toCharArray();
 *      char[] aC = "ABCDEFG".toCharArray();
 * </pre>
 *
 * @author Yuliang Lau
 * @date 2023/9/17 14:29
 */
public class LockSupportTest {
    Thread t1 = null;

    Thread t2 = null;

    /**
     * 交替打印aI,aC
     */
    @Test
    public void testLockSupport() {


        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2); //叫醒T2
                LockSupport.park(); //T1图塞
            }

        }, "t1"
        );
        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park(); //T2图塞
                System.out.print(c);
                LockSupport.unpark(t1); //叫醒T1

            }

        }, "t2"
        );

        t1.start();
        t2.start();
    }

    /**
     * CountDownLatch
     */
    @Test
    public void testSync() {
        CountDownLatch countDownLatch = new CountDownLatch(1);//保证t1先执行
        final Object o = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();//让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//必须，否则无法停止进程
            }
        }, "t1").start();
        new Thread(() -> {
            countDownLatch.countDown();
            synchronized (o) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}