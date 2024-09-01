package com.codetop.trie;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 */
public class MagicDictionary {

    public class TrieNode {
        private boolean isEnd;
        private TrieNode[] childNodes;

        public TrieNode() {
            isEnd = false;
            childNodes = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int id = word.charAt(i) - 'a';
            if (node.childNodes[id] == null) {
                node.childNodes[id] = new TrieNode();
            }
            node = node.childNodes[id];
        }
        node.isEnd = true;
    }

    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        int n = dictionary.length;
        for (int i = 0; i < n; i++) {
            insert(dictionary[i]);
        }
    }

    public boolean search(String searchWord) {
        return DFS_Search(root, searchWord, 0, false);
    }

    private boolean DFS_Search(TrieNode node, String word, int index, boolean isChanged) {
        //字符全部遍历完
        if (index == word.length()) {
            return isChanged && node.isEnd;
        }
        int i = word.charAt(index) - 'a';
        //字典树是否存在该字符
        if (node.childNodes[i] != null) {
            if (DFS_Search(node.childNodes[i], word, index + 1, isChanged)) {
                return true;
            }
        }
        //不存在 判断是否有进行替换
        // diff为false表示没有替换过单词，可以进行替换
        if (!isChanged) {
            //枚举当前结点的所有子结点进行遍历
            //匹配剩余字符
            for (int j = 0; j < 26; j++) {
                if (j != i && node.childNodes[j] != null) {
                    if (DFS_Search(node.childNodes[j], word, index + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dic = {"MagicDictionary", "buildDict", "search", "search", "search", "search"};
        magicDictionary.buildDict(dic);
        magicDictionary.search("hhllo");
    }
}
