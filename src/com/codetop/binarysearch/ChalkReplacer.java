package com.codetop.binarysearch;

/**
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，
 * 直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
 * <p>
 * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，
 * 他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
 * <p>
 * 请你返回需要 补充 粉笔的学生 编号 。
 */
public class ChalkReplacer {

    public static void main(String[] args) {
        int[] chalk = {3, 4, 1, 2};
        chalkReplacer2(chalk, 25);
    }

    public static int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n];
        sum[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + chalk[i];
        }
        long leftChalk = k % sum[n - 1];
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] <= leftChalk) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == -1 ? 0 : right;
    }

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] sum = new long[n];
        sum[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + chalk[i];
        }
        //对合取余得到最后一轮剩余的粉笔
        k = (int) (k % sum[n - 1]);

        //二分法，查找前缀合数组
        //蓝色：和<=k，红色>k
        //return rigth
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] <= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
