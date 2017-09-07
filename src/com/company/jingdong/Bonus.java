package com.company.jingdong;

/**
 * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，游戏在一个6*6的棋盘上进行，
 * <p>
 * 上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，他需要从左上角开始游戏，每次只能向下或者向右移动一步，
 * 到达右下角停止，一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。
 * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，
 * <p>
 * 保证每个礼物价值大于100小于1000。
 * <p>
 * 思路动态规划
 *
 * @author XIAO
 */
public class Bonus {
    public int getMost(int[][] board) {
        int row = board.length;// 行长
        int col = board[0].length;// 列数
        int[][] dp = new int[row][col];
        dp[0][0] = board[0][0];

        /**
         * 下面的两个for循环用于初始化第一行和第一列dp[][]数组的值
         */
        // 第一列的值，只能从上面移动下来
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }

        // 第一行的值，只能从左边移动过来
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + board[0][j];
        }

        /**
         * 下面的双层for循环用语计算中间行列的值
         * dp[i][j]记录着从左上角到[i][j]位置能够取到的最多的礼物
         */
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = board[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[row - 1][col - 1];
    }
}
