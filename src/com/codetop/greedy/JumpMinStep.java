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
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int end = 0;//当前一步的最大覆盖范围
        int maxPosition = 0;//下一步的最大覆盖范围
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //当前找能跳的最远的右边界
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //如果下一步的右边界，已经能覆盖数组终点了，那么不需要遍历了，加上一步就可以了
            if (maxPosition >= nums.length - 1) {
                steps++;
                break;
            }
            if (i == end) { //遇到边界，就更新边界，并且步数加一，如果已经遍历到了所能到达的范围的边界，此时必须进行一次跳跃，同时更新所能到达的范围的边界
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * <p>
     * 对于每一个可以到达的位置 x，它使得 x+1,x+2,...,x+nums[x] 这些连续的位置都可以到达。
     * 这样以来，我们依次遍历数组中的每一个位置，并实时维护最远可以到达的位置。
     * 对于当前遍历到的位置 xxx，如果它在 最远可以到达的位置 的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，
     * 因此我们可以用 x+nums[x]更新最远可以到达的位置。
     * <p>
     * 在遍历的过程中，如果 最远可以到达的位置大于等于数组中的最后一个位置，那就说明最后一个位置可达，
     * 我们就可以直接返回 True 作为答案。反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
     */
    public boolean canJump(int[] nums) {
        int maxPosition = 0;//维护一个当前可以到达的最大位置
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > maxPosition) { // 无法到达 i
                return false;
            }
            maxPosition = Math.max(maxPosition, i + nums[i]); // 从 i 最右可以跳到 i + nums[i]
            if (maxPosition >= n - 1) {
                return true;
            }
        }
        return true;
    }
}
