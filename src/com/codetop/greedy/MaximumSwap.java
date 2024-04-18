package com.codetop.greedy;

public class MaximumSwap {

    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     * 9952767
     */
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int len = charArray.length;
        // 需要交换的左边的元素下标
        int idx1 = -1;
        // 需要交换的右边元素下标
        int idx2 = 0;
        // 当前最大值的元素下标，初始化为最后一个
        int maxIdx = len - 1;
        // 从后往前遍历，越往左边，交换的收益越大
        for (int i = len - 2; i >= 0; i--) {
            // 如果右边比左边小，直接将最大元素替换成右边的i
            if (charArray[maxIdx] < charArray[i]) {
                maxIdx = i;
            } else if (charArray[maxIdx] > charArray[i]) {
                //左边i小于右边maxIdx,则交换i和maxIdx一定可以得到一个更大的数。记录下此时的下标
                // 如果右边比左边大，则记录需要交换的左边下标i，右边下标maxIdx
                idx1 = i;
                idx2 = maxIdx;
            }
            // 注意这里不需要判断相当，相等不需要做任何操作，继续遍历
        }
        // 如果 -1说明是递减序列，不需要交换返回原值就是最大的
        if (idx1 == -1) {
            return num;
        }
        // 开始交换
        char tmp = charArray[idx1];
        charArray[idx1] = charArray[idx2];
        charArray[idx2] = tmp;
        // 交换后转换为整数返回
        return Integer.valueOf(new String(charArray));
    }
}
