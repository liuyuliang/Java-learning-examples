package org.example.jdk.thread;

import org.junit.jupiter.api.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * ClassName: ThreadLocalTest
 * Description: @link hreadLocal 只能在自己的线程里才能读取到
 *
 * @author Yuliang Lau
 * @date 2023/9/24 17:33
 */
public class ThreadLocalTest {
    /**
     * 软引用
     */
    @Test
    public void soft() {
        //软引用
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        //弱引用
        WeakReference<String> n = new WeakReference<>(new String());
    }
}
