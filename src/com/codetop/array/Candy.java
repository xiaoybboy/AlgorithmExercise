package com.codetop.array;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class Candy {

    /**
     * 我们可以将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理。
     * 左规则：当 ratings[i−1]<ratings[i] 时，i 号学生的糖果数量将比 i−1 号孩子的糖果数量多。
     * 右规则：当 ratings[i]>ratings[i+1] 时，i 号学生的糖果数量将比 i+1号孩子的糖果数量多。
     * <p>
     * 我们遍历该数组两次，处理出每一个学生分别满足左规则或右规则时，最少需要被分得的糖果数量。每个人最终分得的糖果数量即为这两个数量的最大值。
     * 具体地，以左规则为例：我们从左到右遍历该数组，假设当前遍历到位置 iii，如果有 ratings[i−1]<ratings[i]那么 i 号学生的糖果数量将比 i−1号孩子的糖果数量多，
     * 我们令 left[i]=left[i−1]+1 即可，否则我们令 left[i]=1
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        //左规则
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        //右规则
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        //计算糖果数量
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}
