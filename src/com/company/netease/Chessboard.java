package com.company.netease;

import java.util.Scanner;

/**
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。小易会找出棋盘中某一列中拥有
 * 相同颜色的最大的区域去涂画，帮助小易算算他会涂画多少个棋格。
 * <p>
 * 输入数据包括n+1行： 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
 * 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色
 * <p>
 * 输出小易会涂画的区域大小
 *
 * @author XIAO
 */
public class Chessboard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num = sc.nextInt();
            sc.nextLine();
            char[][] str = new char[num][num];
            for (int i = 0; i < num; i++)
                str[i] = sc.nextLine().toCharArray();
            int max = 0;// 所有列的最大连续块

            for (int i = 0; i < num; i++) {// 列
                int dis = 0;// 一列中的连续块个数
                for (int x = 0, y = 0; y < num; y++) {// 第x和第y行，x表示开始行，y表示结束行
                    if (str[x][i] == str[y][i])
                        dis++;
                    else {
                        if (dis > max)
                            max = dis;
                        x = y;
                        dis = 0;
                        y--;// 因为循环结束时y++,所以先--
                    }
                }
                if (dis > max)
                    max = dis;
            }
            System.out.println(max);
        }
        sc.close();
    }

}