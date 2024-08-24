package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中 「优美子数组」 的数目。
 */
public class NumberOfSubarrays {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        numberOfSubarrays(nums, 2);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int curOddCnt = 0, n = nums.length;
        int ans = 0;
        while (right < n) {
            // 右指针先走，每遇到一个奇数则 oddCnt++。
            if ((nums[right] & 1) == 1) {
                curOddCnt++;
            }
            right++;
            //curOddCnt=k的时候，统计right为右边界(包含right右边的偶数)满足条件的数量
            if (curOddCnt == k) {
                int tmp = right;
                //计算right右侧为偶数的数量
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                //计算left左侧为偶数的数量
                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int leftEvenCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                // 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
                // (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
                // 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
                // (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
                // 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
                ans += (leftEvenCnt + 1) * (rightEvenCnt + 1);
                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                curOddCnt--;
            }
        }
        return ans;
    }

    public int numberOfSubarrays2(int[] nums, int k) { // hash+前缀模板
        //sum当前数字为奇数的前缀和
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            // 更新奇数个数的总数
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            // 如果当前数字为奇数，增加奇数个数的计数
            if ((num & 1) == 1) {
                sum++;
            }
            // 更新答案，加上当前奇数个数减去k的情况的总数
            ans += cnt.getOrDefault(sum - k, 0);
        }
        return ans;
    }
}
