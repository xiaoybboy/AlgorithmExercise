package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    public class Node {
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
    Map<Integer, Node> cache = new HashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveNodeHead(node);
        return node.value;
    }

    private void moveNodeHead(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        addToHead(node);
    }

    private void addToHead(Node node) {
        Node cur = head.next;
        head.next = node;
        node.prev = head;

        node.next = cur;
        cur.prev = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveNodeHead(node);
            cache.put(key, node);
            return;
        }
        Node newNode = new Node(key, value);
        addToHead(newNode);
        cache.put(key, newNode);
        if (cache.size() > capacity) {
            removeTail();
        }
    }

    private void removeTail() {
        Node last = tail.prev;
        Node lastPrev = last.prev;
        lastPrev.next = tail;
        tail.prev = lastPrev;
        cache.remove(last.key);
    }
}
