package com.yk.algorithm.test;

import com.yk.algorithm.main.LruCache;

/**
 * @author ke.yang1
 * @description
 * @date 2021/6/27 3:01 下午
 */
public class LruTest {
    public static void main(String[] args) {
        LruCache lruCache = new LruCache<>(100);
        lruCache.put("str",1);

    }


}
