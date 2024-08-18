package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * 实现 StockSpanner 类：
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 */
public class StockSpanner {

    Deque<Stock> deque;
    int index;

    public StockSpanner() {
        deque = new ArrayDeque<>();
        //虚拟一个节点，值为maxValue,避免栈空
        index = -1;
        deque.push(new Stock(index, Integer.MAX_VALUE));
    }

    public int next(int price) {
        index++;
        //栈中弹出所有小于price的元素
        while (price >= deque.peek().price) {
            deque.pop();
        }
        int ans = index - deque.peek().index;
        deque.push(new Stock(index, price));
        return ans;
    }

    public class Stock {
        private int index;
        private int price;

        public Stock(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
}
