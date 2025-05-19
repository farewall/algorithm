package com.xusn.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
        }
    }

    int capacity;

    Node head;

    Node tail;

    Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void moveToHead(Node node) {
        // 将当前节点移动到头部等价于删除节点+新增节点
        removeNode(node);
        addNode(node);
    }

    public void addNode(Node node) {
        Node originTop = head.next;
        // 更新新节点的前驱和后继
        node.prev = head;
        head.next = node;

        //更新原始节点的前驱和后继
        originTop.prev = node;
        node.next = originTop;
    }

    public void removeNode(Node node) {
        // 将该节点的前驱和后继节点连接上
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 访问过后放在头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // 需要新增
            if (cache.size() == capacity) {
                // 从尾部去除
                Node removeNode = tail.prev;
                removeNode(removeNode);
                cache.remove(removeNode.key);
                Node newNode = new Node(key, value);
                addNode(newNode);
                cache.put(key, newNode);
            } else {
                Node newNode = new Node(key, value);
                addNode(newNode);
                cache.put(key, newNode);
            }
        } else {
            // 更新节点的信息并放到头部
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        // [null,null,null,1,null,-1,null,-1,3,4]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
