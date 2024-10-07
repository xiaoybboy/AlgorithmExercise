package com.codetop.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        //城市的数量
        int length = isConnected.length;
        //表示哪些城市被访问过
        boolean[] visited = new boolean[length];
        //相连的城市数量，也就是省份
        int count = 0;
        //队列，存放的是同一个省份的城市
        Queue<Integer> queue = new LinkedList<>();
        //遍历所有的城市
        for (int i = 0; i < length; i++) {
            //如果当前城市被访问过，则跳过
            if (visited[i])
                continue;
            //否则表示遇到了一个新的城市，count要加1
            count++;
            //然后把当前城市加入到队列中
            queue.add(i);
            //这个队列中的所有城市都是同一省份的，需要把他们都
            //标记为已访问过，然后在继续查找和他们相连的，他们
            //也是同一省份的，也需要加入到队列中
            while (!queue.isEmpty()) {
                //出队
                int j = queue.poll();
                visited[j] = true;//把它标记为已访问过
                //然后再继续查找和他相连的并且没被访问过的城市
                for (int k = 0; k < length; k++) {
                    if (isConnected[j][k] == 1 && !visited[k]) {
                        queue.add(k);
                    }
                }
            }
        }
        return count;
    }
}
