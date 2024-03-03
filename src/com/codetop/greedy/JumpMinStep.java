package com.codetop.greedy;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数
 */
public class JumpMinStep {

    /**
     * 贪心算法
     * <p>
     * end: 表示当前能跳的边界
     * <p>
     * 数组为：[2,3,1,2,4,2,3]
     * 1.下标为0出发，可以跳到下标1或者2，可以看出，下标1跳得更远，所以选择下标1
     * 2.下标1出发，可以选择下标2，下标3，下标4，很明显下标4可以跳得更远。
     * 最终步数为3
     * <p>
     * 代码执行：1.下标为0；边界为下标2，第一步能达到的最远距离也是下标2;
     * 2.下标1：更新maxPosition 为下标4；此时还未抵达上一个边界2。还不能确定要不要跳下一步。
     * 3.下标2：nums[i] + i = 3<maxPosition;已经到达上一个边界，必须进行跳跃了，更新边界为4为下一边界。并且跳跃+1；
     * ...后面循环同理
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;//能到达的最远位置
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一，如果已经遍历到了所能到达的范围的边界，此时必须进行一次跳跃，同时更新所能到达的范围的边界
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
