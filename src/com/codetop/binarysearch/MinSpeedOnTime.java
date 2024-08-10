package com.codetop.binarysearch;

/**
 * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，
 * <p>
 * 其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
 * <p>
 * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
 * <p>
 * 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
 * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，你 -1 。
 * <p>
 * 生成的测试用例保证答案不超过 107 ，且 hour 的 小数点后最多存在两位数字 。
 */
public class MinSpeedOnTime {

    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        minSpeedOnTime(dist, 3);
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int maxSpeed = 10000000;
        //首先检查，以最大速度运行时，是否能准时到达
        if (check(dist, maxSpeed, hour)) {
            return -1;
        }
        int start = 0, end = 10000000 + 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //计算当前速度speed，耗时
            if (check(dist, mid, hour)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private static boolean check(int[] dist, int speed, double hour) {
        double total = 0;
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                total += ((double) dist[i] / (double) speed);
            } else {
                total += (dist[i] % speed == 0 ? dist[i] / speed : dist[i] / speed + 1);
            }
            if (total > hour) {
                return true;
            }
        }
        return false;
    }
}
