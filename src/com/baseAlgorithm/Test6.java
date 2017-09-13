package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-10 15:49
 **/
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = GetUglyNumber(N);
        System.out.println(res);

    }

    private static int GetUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;// i2,i3,i5分别记录丑数的因子中2,3,5的个数
        for (int i = 1; i < index; i++) {
            result[i] = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            if (result[i] == result[i2] * 2) {
                i2++;
            }
            if (result[i] == result[i3] * 3) {
                i3++;
            }
            if (result[i] == result[i5] * 5) {
                i5++;
            }
        }
        return result[index - 1];
    }

    private static int min(int i, int j) {
        return i > j ? j : i;
    }
}
