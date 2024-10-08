package com.codetop.doublePoint;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class MaxArea {
    /***
     * 双指针
     * 面积 = min(h[i],h[j]) *(j-i)
     * 左右两个指针：
     * 1.两个指针相距的距离越远，面积越大
     * 2.每次往内移动短板，面积才有可能增大
     */
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;

        int ans = 0;
        while (start < end) {
            int curArea = Math.min(height[start], height[end]) * (end - start );
            ans = Math.max(ans, curArea);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }
}
