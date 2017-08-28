package com.company.jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。
 * f(x)表示把x这个数用十进制写出后各个数位上的数字之和。如f(123)=1+2+3=6。
 * g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么g(123)=1+1+1+1+0+1+1=6。
 * 小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数字称为幸运数，现在他想知道，小于等于n的幸运数有多少个。
 * <p>
 * <p>
 * 输入
 * <p>
 * 第一行一个整数T(T<=10000)表示数据组数，每组数据输入一个数n(n<=100000)。
 * <p>
 * 样例输入
 * <p>
 * 3
 * <p>
 * 1
 * <p>
 * 5
 * <p>
 * 21
 * <p>
 * 输出 每组数据输出一行，小于等于n的幸运数个数。
 * <p>
 * 样例输出 1
 * <p>
 * 1
 * <p>
 * 3
 *
 * @author XIAO
 */
public class LuckyNumber2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int t = scan.nextInt();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < t; i++) {
                int n = scan.nextInt();
                int count = 0;
                for (int j = n; j >= 1; j--) {
                    if (map.containsKey(j)) {
                        count += map.get(j);
                        break;
                    }
                    if (isLucky(j)) {
                        count++;
                    }
                }
                map.put(n, count);
                System.out.println(count);
            }
        }
    }

    public static boolean isLucky(int num) {
        String str = String.valueOf(num);
        int fx = 0;
        for (int i = 0; i < str.length(); i++) {
            fx += str.charAt(i) - '0';
        }

        int gx = 0;
        while (num / 2 != 0) {
            gx += num % 2;
            num /= 2;
        }
        gx += num % 2;

        if (fx == gx) {
            return true;
        } else {
            return false;
        }
    }
}
