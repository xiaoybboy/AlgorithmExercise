package com.offer2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 和为S的连续正数序列
 * <p>
 * 思路：从递增数组中两个何=和为s的数得到启示，我们也可以设置两个指针，一个指向当前序列的最小的数，一个指向当前序列最大的数。
 * 1）设置两个指针，一个为small指向当前正数序列中最小的数，一个为big指向当前正数序列中最大的数；
 * 2）若是当前的正数序列之和大于S，那么缩小序列范围，让small指针不停往前走，知道等于S停止；
 * 3）若是当前的正数序列之和小于S，那么扩大序列范围，让big指针不停往前走，直到和为S停止；
 * 注意点：设置mid变量，赋值为(1+s)/2，因为何为s的序列至少包括两个数，所以small要小于s的一半；
 * <p>
 * 滑动窗口：i到j
 * 滑动窗口的操作
 * <p>
 * 扩大窗口，j += 1
 * 缩小窗口，i += 1
 * 算法步骤：
 * 初始化，i=1,j=1, 表示窗口大小为0
 * 如果窗口中值的和小于目标值sum， 表示需要扩大窗口，j += 1
 * 否则，如果狂口值和大于目标值sum，表示需要缩小窗口，i += 1
 * 否则，等于目标值，存结果，缩小窗口，继续进行步骤2,3,4
 *
 * @author XIAO
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        ArrayList<ArrayList<Integer>> result = FindContinuousSequenceSum(sum);
    }

    /**
     * 找到和为s的序列
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequenceSum(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int start = 1, high = 2;
        int curSum = 3;
        while (start <= sum / 2) {
            if (curSum < sum) {
                high++;
                curSum += high;
            } else if (curSum > sum) {
                curSum -= start;
                start++;
            } else {
                ArrayList<Integer> resSingle = new ArrayList<>();
                for (int i = start; i <= high; i++) {
                    resSingle.add(i);
                }
                results.add(resSingle);
                curSum -= start;
                start++;
                high++;
                curSum += high;
            }
        }
        return results;
    }
}
