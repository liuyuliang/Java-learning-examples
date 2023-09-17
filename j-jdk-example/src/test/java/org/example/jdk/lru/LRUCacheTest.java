package org.example.jdk.lru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: LRUCacheTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/17 20:14
 */
class LRUCacheTest {
    @Test
    void removeEldestEntry() {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache); // 输出：{1=one, 2=two, 3=three}
        cache.put(4, "four");
        System.out.println(cache); // 输出：{2=two, 3=three, 4=four}
        cache.put(5, "five");
        System.out.println(cache); // 输出：{3=three, 4=four, 5=five}
    }


}