package org.example.jdk.lru;

/**
 * ClassName: L
 * Description:Java中的LRU（Least Recently Used）算法是一种缓存淘汰策略。当缓存空间已满时，LRU算法会淘汰最近最少使用的元素。在Java中，可以使用LinkedHashMap实现一个简单的LRU缓存。
 *
 * @author Yuliang Lau
 * @date 2023/9/17 20:12
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        // 设置accessOrder为true，使得LinkedHashMap按照访问顺序排序
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当缓存大小超过设定的最大值时，移除最久未使用的元素
        return size() > cacheSize;
    }


}

