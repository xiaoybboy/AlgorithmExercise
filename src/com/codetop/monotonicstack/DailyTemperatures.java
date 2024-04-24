package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {
    /**
     * 单调栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Temperature> deque = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[i] > deque.peek().value) {
                Temperature temperature = deque.pop();
                result[temperature.index] = i - temperature.index;
            }
            deque.push(new Temperature(temperatures[i], i));
        }
        return result;
    }

    class Temperature {
        int value;
        int index;

        public Temperature(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
