package com.codetop.doublePoint;

import java.util.Arrays;

/**
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回 承载所有人所需的最小船数 。
 */
public class NumRescueBoats {

    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int ans = 0;
        int start = 0, end = n - 1;
        Arrays.sort(people);
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            ans++;
        }
        return ans;
    }
}
