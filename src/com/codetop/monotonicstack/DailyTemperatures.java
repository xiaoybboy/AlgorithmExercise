package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures2(int[] temperatures) {
        Deque<Temperature> deque = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek().value < temperatures[i]) {
                Temperature temperature = deque.pop();
                result[temperature.index] = i - temperature.index;
            }
            deque.push(new Temperature(i, temperatures[i]));
        }
        return result;
    }


    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Temperature> deque = new ArrayDeque<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek().value < temperatures[i]) {
                Temperature temperature = deque.pop();
                answer[temperature.index] = i - temperature.index;
            }
            deque.push(new Temperature(temperatures[i], i));
        }
        while (!deque.isEmpty()) {
            Temperature temperature = deque.pop();
            answer[temperature.index] = 0;
        }
        return answer;
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
