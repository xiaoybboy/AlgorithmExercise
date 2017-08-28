package com.company.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
 * 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
 * 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
 * <p>
 * 输入描述:
 * 首先输入一个正整数N三维坐标系内的点的个数.(N <= 50)
 * 接下来N行，每一行输入 c x y z，c为'R', 'G', 'B' 的其中一个。x，y，z是该点的坐标。(坐标均是0到999之间的整数)
 * <p>
 * 输出描述:
 * 输出一个数表示最大的三角形面积，保留5位小数。
 * <p>
 * 输入例子1:
 * 5
 * R 0 0 0
 * R 0 4 0
 * R 0 0 3
 * G 92 14 7
 * G 12 16 8
 * <p>
 * 输出例子1:
 * 6.00000
 *
 * @author XIAO
 */
public class MaxRGBTriangle {
    static class Point {
        char color;
        int x;
        int y;
        int z;
    }

    // 计算两点之间的距离
    public static double distance(Point A, Point B) {
        return Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y) + (A.z - B.z) * (A.z - B.z));
    }

    // 判断三个点颜色是否满足条件
    public static boolean colorIsMathed(Point A, Point B, Point C) {
        if (A.color == B.color && B.color == C.color) { // 三个点的颜色相同
            {
                return true;
            }
        } else if (A.color != B.color && A.color != C.color && B.color != C.color) { // 三个点的颜色都不相同
            {
                return true;
            }
        } else {
            return false;
        }
    }

    // 判断三个点是否能构成三角形
    //判断三条线段能否构成三角形定理：两边的差＜第三边＜两边之和
    public static boolean isSan(Point A, Point B, Point C) {
        double a = distance(A, B);
        double b = distance(A, C);
        double c = distance(B, C);
        if (a < (b + c) && b < (a + c) && c < (a + b)
                && a > Math.abs(b - c) && b > Math.abs(a - c) && c > Math.abs(a - b)) {
            return true;
        }
        return false;
    }

    // 计算三角形面积
    public static double getArea(Point A, Point B, Point C) {
        double a = distance(A, B);
        double b = distance(A, C);
        double c = distance(B, C);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));//海伦公式
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // 将输入的点添加到 List 中
        for (int i = 0; i < n; i++) {
            Point p = new Point();
            String[] arr = sc.nextLine().split(" ");
            p.color = arr[0].charAt(0);
            p.x = Integer.parseInt(arr[1]);
            p.y = Integer.parseInt(arr[2]);
            p.z = Integer.parseInt(arr[3]);
            list.add(p);
        }

        double maxArea = 0;
        double area = 0;
        // 遍历所有可能的三个点
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    Point A = list.get(i);
                    Point B = list.get(j);
                    Point C = list.get(k);

                    if (isSan(A, B, C) && colorIsMathed(A, B, C)) {
                        area = getArea(A, B, C);
                    }
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        System.out.format("%.5f", maxArea);

    }

}
