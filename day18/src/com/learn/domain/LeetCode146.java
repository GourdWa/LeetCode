package com.learn.domain;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-05-25  10:18
 * @description
 */
//使用哈希表和双端队列实现，复杂度较高
/*class LRUCache {
    private int capacity;
    private int size = 0;
    Map<Integer, Integer> data = new HashMap<>();
    Deque<Integer> deque = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (size > 0 && data.containsKey(key)) {
            deque.remove(key);
            deque.add(key);
            return data.get(key);
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            deque.remove(key);
        } else if (size >= capacity) {
            Integer pollKey = deque.poll();
            data.remove(pollKey);
        } else {
            size++;
        }
        deque.add(key);
        data.put(key, value);
    }
}*/

//使用哈希表和双链表实现
class LRUCache {

    class DLinkList {
        private int key;
        private int value;
        private DLinkList prev;
        private DLinkList next;

        public DLinkList(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, DLinkList> data = new HashMap<>();
    private DLinkList head = new DLinkList(0, 0);
    private DLinkList tail = new DLinkList(0, 0);
    private int capacity;
    private int size;

    public LRUCache() {
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkList node = data.get(key);
        if (node == null)
            return -1;
        remove(node);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkList node = data.get(key);
        if (node == null) {
            node = new DLinkList(key, value);
            moveToHead(node);
            size++;
            data.put(key, node);
            if (size > capacity) {
                DLinkList tailPrevNode = removeTail();
                data.remove(tailPrevNode.key);
                size--;
            }
        } else {
            node.value = value;
            remove(node);
            moveToHead(node);
        }
    }

    private DLinkList removeTail() {
        DLinkList tailPrevNode = tail.prev;
        remove(tailPrevNode);
        return tailPrevNode;
    }

    private void remove(DLinkList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkList node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }
}

public class LeetCode146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
