package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        removeToHead(node);
        return node.value;
    }

    private void addToHead(Node node) {
        Node cur = head.next;

        head.next = node;
        node.prev = head;

        node.next = cur;
        cur.prev = node;
    }

    private void removeToHead(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        addToHead(node);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeToHead(node);
            return;
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        if (cache.size() > capacity) {
            removeTail();
            addToHead(newNode);
        }
    }

    private void removeTail() {
        Node curTail = tail.prev.prev;
        curTail.next = tail;
        tail.prev = curTail;
    }
}
