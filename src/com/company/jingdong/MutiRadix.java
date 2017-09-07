package com.company.jingdong;

import java.util.Scanner;

/**
 * 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，现在，她正在玩一个数值
 * 变换的游戏。
 * 她发现计算机中经常用不同的进制表示一个数，如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为
 * 三位数1、7、3，按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11,。小B感兴趣的是，
 * 一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？ 所有的计算均基于十进制进行，
 * 结果也用十进制表示为不可约简的分数形式。
 *
 * @author XIAO
 * @since 2017-09-07 19:19
 **/
public class MutiRadix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int sum = 0;
            for (int i = 2; i <= num - 1; i++) {
                sum += hexSum(num, i);
            }
            int gcd = gcd(sum, num - 2);//求最大公约数
            System.out.println(sum / gcd + "/" + (num - 2) / gcd);
        }
        sc.close();
    }

    /**
     * 求进制为i时，num表示的和
     *
     * @param num
     * @param base
     * @return
     */
    private static int hexSum(int num, int base) {
        int sum = 0;
        while (num != 0) {
            sum += num % base;
            num = num / base;
        }
        return sum;
    }

    /**
     * 求两个数的最大公约数
     *
     * @param one
     * @param two
     * @return
     */
    private static int gcd(int one, int two) {
        int gcd = 0;
        int min = Math.min(one, two);
        for (int i = min; i > 0; i--) {
            if (one % i == 0 && two % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}
