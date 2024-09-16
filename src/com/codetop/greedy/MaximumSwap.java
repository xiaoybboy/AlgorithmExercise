package com.codetop.greedy;

public class MaximumSwap {

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     * 9952767
     */
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxIndex = n - 1;

        //记录可以交换的位置，希望index越左边越好
        int index = -1, index2 = 0;
        for (int i = n - 2; i >= 0; i--) {
            //更新maxIndex
            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            } else
                //如果遇到当前值<后面的最大值，这时候交换两个数一定可以得到一个更大的数
                if (chars[i] < chars[maxIndex]) {
                    index = i;
                    index2 = maxIndex;
                }
        }
        //本身就是倒序的，无需交换
        if (index == -1) {
            return num;
        }
        //交换index和index2
        swap(chars, index, index2);
        return Integer.parseInt(new String(chars));
    }

    private void swap(char[] chars, int index, int index2) {
        char temp = chars[index];
        chars[index] = chars[index2];
        chars[index2] = temp;
    }
}
