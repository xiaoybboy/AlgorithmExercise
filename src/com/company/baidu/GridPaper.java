package com.company.baidu;

import java.util.Scanner;

/**
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用
 * 一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的
 * 最小面积是多少。
 * <p>
 * 输入描述:
 * 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 * <p>
 * 输出描述:
 * 一行输出最小面积
 * <p>
 * 输入例子1:
 * 2
 * 0 0
 * 0 3
 * <p>
 * 输出例子1:
 * 9
 *
 * @author XIAO
 * @time 2017-09-07 15:44
 **/
public class GridPaper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
            int side = Math.max((maxX - minX), (maxY - minY));
            System.out.println(side * side);
        }
    }
}
