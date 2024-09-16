package com.codetop.trie;

/**
 * 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie {

    public class TrieNode {
        boolean isEnd;       // 标记是否尾节点
        private TrieNode[] childNodes;// 子节点列表

        public TrieNode() {
            childNodes = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            // 将当前字符添加到当前节点对应的子节点位置，然后递归更新
            int id = word.charAt(i) - 'a';
            TrieNode node = cur.childNodes[id];
            //判断子节点中是否存在这个字符，如果不存在的话加进去
            if (node == null) {
                node = new TrieNode();
                cur.childNodes[id] = node;
            }
            //接着往下继续构造前缀树结构
            cur = node;
        }
        //字符串遍历完成之后，把当前节点是否是重点设置成true
        cur.isEnd = true;
    }

    public boolean search(String word) {
        //从根节点开始搜索
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            TrieNode node = cur.childNodes[id];
            //如果某个字母在前缀树中不存在
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int id = prefix.charAt(i) - 'a';
            TrieNode node = cur.childNodes[id];
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return true;
    }
}
