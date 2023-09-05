package org.example.jdk.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: ReentrantLockTest
 * Description:<pre>
 * ReentrantLock 介绍
 * ReentrantLock是一个可重入的互斥锁，又被称为“独占锁”。
 * ReentrantLock锁在同一个时间点只能被一个线程锁持有；可重入表示，ReentrantLock锁可以被同一个线程多次获取。
 * ReentraantLock是通过一个FIFO的等待队列来管理获取该锁所有线程的。在“公平锁”的机制下，线程依次排队获取锁；而“非公平锁”在锁是可获取状态时，不管自己是不是在队列的开头都会获取锁。
 * </pre>
 *
 * @author Yuliang Lau
 * @date 2023/9/5 9:38
 */
public class ReentrantLockTest {
    // 创建锁对象,默认为非公平锁(false)
    private static final ReentrantLock lock = new ReentrantLock(true);

    @Test
    public void reetrantLockTest() {
        // 定义线程任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 加锁 lock 不要放在 try 代码内
                lock.lock();
                try {
                    // 打印执行线程的名字
                    System.out.println("线程:" + Thread.currentThread().getName());
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        };
        // 创建多个线程
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }


    }
}
