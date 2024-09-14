package com.codetop.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。
 * 其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 */
public class LeastBricks {
    //1.计算每一行缝隙的位置
    //2.计算最多缝隙的位置
    //3.行数n-缝隙最多数量cnt = 最终结果
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        //记录每一层的各个缝隙的位置
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int x : wall.get(i)) {
                sum += x;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            //不能从两边穿过，remove最后一个
            map.remove(sum);
        }
        int ans = n;
        for (int u : map.keySet()) {
            int cnt = map.get(u);
            ans = Math.min(ans, n - cnt);
        }
        return ans;
    }
}
