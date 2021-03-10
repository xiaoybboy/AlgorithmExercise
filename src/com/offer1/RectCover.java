package com.offer1;

/**
 * 矩阵覆盖
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 解题思路：
 * <p>
 * 当n=1时，只能竖着覆盖，f(1)=1;
 * <p>
 * 当n=2时，既可以横着覆盖，也可以竖着覆盖，f(2)=2;
 * <p>
 * 当n=N时，只需要考虑第一块如何覆盖即可，详见下图：
 * <p>
 * 横着放---剩余f(n-2)
 * 竖着放---剩余f(n-1)
 * <p>
 * 所以 f(n) = f(n-1) + f(n-2)
 */
public class RectCover {
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int f1 = 1;
        int f2 = 2;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
}
