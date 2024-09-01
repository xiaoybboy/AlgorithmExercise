package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * 1.int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * 2.void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LRUCache {

    public class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 把当前节点移动到链表头部
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void moveToHead(DLinkedNode node) {
        //把当前节点从链表中删除
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        //当前节点添加到头节点
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        //把头节点添加到头节点后面
        DLinkedNode next = head.next;
        //当前节点的前置节点指向头节点
        node.prev = head;
        //插入当前节点
        next.prev = node;
        node.next = next;
        //头节点的下一节点为当前节点
        head.next = node;
        cache.put(node.key, node);
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            // 把当前节点的值更新为新值
            node.value = value;
            // 把当前节点移动到链表头部
            moveToHead(node);
        } else {
            // 如果当前节点不存在，就创建一个新的节点
            node = new DLinkedNode(key, value);
            // 把当前节点添加到链表头部
            addToHead(node);
            // 如果当前节点数量超过了容量，就删除链表尾部的节点
            if (cache.size() > capacity) {
                removeTail();
            }
        }
    }

    private void removeTail() {
        DLinkedNode node = tail.prev;
        DLinkedNode prev = node.prev;
        prev.next = tail;
        tail.prev = prev;
        cache.remove(node.key);
    }
}
