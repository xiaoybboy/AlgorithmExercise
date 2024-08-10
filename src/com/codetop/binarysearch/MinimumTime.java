package com.codetop.binarysearch;

import java.util.Arrays;

public class MinimumTime {

    public long minimumTime(int[] time, int totalTrips) {
        long minValue = Arrays.stream(time).min().getAsInt();
        long start = minValue - 1, end = totalTrips * minValue;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (check(time, mid, totalTrips)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }

    private boolean check(int[] time, long curTime, int totalTrips) {
        int sum = 0;
        for (int x : time) {
            sum += curTime / x;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
