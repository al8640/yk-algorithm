package com.yk.algorithm.linklist;

import java.util.HashMap;

/**
 * @author ke.yang1
 * @description
 * @date 2021/6/27 3:01 下午
 */
public class LruCache<K,V> {

    private int curCacheSize;
    private int cacheCapacity;
    private HashMap<K,Node> caches;
    private Node first;
    private Node last;

    public LruCache(int size) {
        curCacheSize = 0;
        this.cacheCapacity = size;
        caches = new HashMap<K,Node>(size);
    }

    /**
     * 存储元素 如果缓存中存在该key,则更新对应的val
     * 如果缓存中无该元素，则先判断缓存大小是否已达到阈值，
     *  如果达到，则要先将缓存中最后一个元素删除，并删除node链表中最后一个节点，
     *  如果未达到阈值，则存储当前元素到缓存中，并将当前节点放入node链表的头部
     * @param k
     * @param v
     */
    public void put(K k ,V v){
        Node node = caches.get(k);
        if(node == null){
            if(caches.size() >= cacheCapacity){
                caches.remove(last.key);
                removeLast();
            }
            node = new Node();
            node.key = k;
        }
        node.value = v;
        moveToFirst(node);
        caches.put(k,node);
    }

    /**
     * 根据key获取对应的node节点，并拿到对应的value
     * 并且将链表中的该节点移动至头部节点
     * @param k
     * @return
     */
    public Object get(K k){
        Node node = caches.get(k);
        if(node == null){
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    /**
     * 删除某个缓存
     * 先根据key拿到对应的node节点
     * 然后在链表中删除该node节点
     * 再在map中删除该K,V对
     * @param k
     * @return
     */
    public Object remove(K k ){
        Node node = caches.get(k);
        if(node != null){
            if(node.prev != null){
                node.prev.next = node.next;
            }
            if(node.next != null){
                node.next.prev = node.prev;
            }
            if(node == first){
                first = node.next;
            }
            if(node == last){
                last = node.prev;
            }
        }
        return caches.remove(k);
    }

    /**
     * 清空缓存
     * node链表清空
     * map集合清空
     */
    public void clear(){
        first = null;
        last = null;
        caches.clear();;
    }

    /**
     * 将node链表中的某个节点移动至头部
     * 首先 将该节点的前置节点和后置节点更新
     * 再更新头部节点为该节点
     * @param node
     */
    public void moveToFirst(Node node){
        if(first == null){
            return;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }
        if(node.prev != null){
            node.prev.next = node.next;
        }
        if(node == last){
            last = last.prev;
        }
        if(first == null || last == null){
            first = last = node;
            return;
        }
        node.next = first;
        first.prev = node;
        first = node;
        first.prev = null;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node node = first;
        while(node != null){
            sb.append(String.format("%s:%s ", node.key,node.value));
            node = node.next;
        }

        return sb.toString();
    }

    /**
     * 删除node链表中的最后一个节点
     */
    private void removeLast(){
        if(last != null){
            last = last.prev;
            if(last == null){
                first = null;
            }else{
                last.next = null;
            }
        }

    }

    public static class Node<K,V>{
        private Node prev;
        private Node next;
        private Object key;
        private Object value;

        public Node() {
        }
    }

}
