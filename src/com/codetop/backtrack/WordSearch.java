package com.codetop.backtrack;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class WordSearch {

    public boolean wordPuzzle(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (backTrack(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backTrack(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]) {
            return false;
        }
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1) {
            return true;
        }
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //修改当前坐标的值，避免之前找到过的元素又被找到一次，避免走回头路
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = backTrack(board, word, i + 1, j, index + 1) || backTrack(board, word, i - 1, j, index + 1) ||
                backTrack(board, word, i, j + 1, index + 1) || backTrack(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }
}
