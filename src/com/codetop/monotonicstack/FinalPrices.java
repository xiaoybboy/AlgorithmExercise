package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 */
public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Goods> deque = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = 0; i < prices.length; i++) {
            //去栈中查询更高价格
            //5,3,2,6,7,2,3
            while (!deque.isEmpty() && prices[i] <= deque.peek().price) {
                Goods goods = deque.pop();
                ans[goods.index] = goods.price - prices[i];
            }
            deque.push(new Goods(i, prices[i]));
        }
        //如果后面没有比它小的价格，则不打折
        while (!deque.isEmpty()) {
            Goods goods = deque.pop();
            ans[goods.index] = goods.price;
        }
        return ans;
    }

    public class Goods {
        private int index;
        private int price;

        public Goods(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
}
