package com.xusn.first;

import java.util.HashMap;
import java.util.Map;

/**
 * ������Ʋ�ʵ��һ������  LRU (�������ʹ��) ���� Լ�������ݽṹ��
 * ʵ�� LRUCache �ࣺ
 * LRUCache(int capacity) �� ������ ��Ϊ���� capacity ��ʼ�� LRU ����
 * int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
 * void put(int key, int value) ����ؼ��� key �Ѿ����ڣ�����������ֵ value ����������ڣ����򻺴��в������ key-value ���������������¹ؼ����������� capacity ����Ӧ�� ��� ���δʹ�õĹؼ��֡�
 * ���� get �� put ������ O(1) ��ƽ��ʱ�临�Ӷ����С�
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
        // ����ǰ�ڵ��ƶ���ͷ���ȼ���ɾ���ڵ�+�����ڵ�
        removeNode(node);
        addNode(node);
    }

    public void addNode(Node node) {
        Node originTop = head.next;
        // �����½ڵ��ǰ���ͺ��
        node.prev = head;
        head.next = node;

        //����ԭʼ�ڵ��ǰ���ͺ��
        originTop.prev = node;
        node.next = originTop;
    }

    public void removeNode(Node node) {
        // ���ýڵ��ǰ���ͺ�̽ڵ�������
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // ���ʹ������ͷ��
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // ��Ҫ����
            if (cache.size() == capacity) {
                // ��β��ȥ��
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
            // ���½ڵ����Ϣ���ŵ�ͷ��
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
