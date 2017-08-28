package com.company.jingdong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BF的生日快到了，这一次，小东决定为BF送一份特别的生日礼物为其庆生。作为高智商中的佼佼者，BF在国外求学，因此小东无法与之一起庆生。小东计划送一个生日卡片，
 * <p>
 * 并通过特别的包装让BF永远难忘。
 * <p>
 * 她决定把卡片套装在一系列的信封A = {a1, a2, ...,
 * an}中。小东已经从商店中购买了很多的信封，她希望能够用手头中尽可能多的信封包装卡片。为防止卡片或信封被损坏，只有长宽较小的信封能够装入大些的信封，
 * 同尺寸的信封不能套装，卡片和信封都不能折叠。
 * <p>
 * 小东计算了邮寄的时间，发现她的时间已经不够了，为此找你帮忙包装，你能帮她吗？
 * <p>
 * 输入 输入有若干组，每组的第一行包含三个整数n, w, h，1<=n<=5000, 1<=w,
 * h<=10^6，分别表示小东手头的信封数量和卡片的大小。紧随其后的n行中，每行有两个整数wi和hi，为第i个信封的大小，1<=wi, hi<=10^6。
 * <p>
 * 样例输入
 * <p>
 * 2 1 1
 * <p>
 * 2 2
 * <p>
 * 2 2
 * <p>
 * 3 3 3
 * <p>
 * 5 4
 * <p>
 * 12 11
 * <p>
 * 9 8
 * <p>
 * 输出
 * 对每组测试数据，结果第一行中输出最多能够使用的信封数量，结果第二行中按使用顺序输出信封的编号。由于小东有洁癖，她对排在前面的信封比较有好感，若有多个信封可用，她喜欢用最先拿到的信封。另外别忘了，小东要求把卡片装入能够装的最小信封中。
 * 如果卡片无法装入任何信封中，则在单独的行中输出0。
 * <p>
 * 样例输出 1 1 3 1 3 2
 *
 * @author XIAO
 */
public class BirthDayPrize {

    public static int n, w, h;
    public static int[] next, memo, ws, hs;

    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        while (br.hasNextInt()) {
            n = br.nextInt();
            w = br.nextInt();
            h = br.nextInt();

            ws = new int[n];
            hs = new int[n];
            for (int i = 0; i < n; i++) {
                ws[i] = br.nextInt();
                hs[i] = br.nextInt();
            }

            next = new int[n + 2];
            Arrays.fill(next, -1);
            memo = new int[n + 2];
            Arrays.fill(memo, -1);
            int ans = go(n + 1);
            memo = null;
            ws = null;
            hs = null;
            int pos = next[n + 1];
            ArrayList<Integer> nums = new ArrayList<Integer>();
            while (pos != n) {
                nums.add(0, pos + 1);
                pos = next[pos];
            }
            System.out.println(ans - 1);
            if (ans != 1) {
                for (int i = 0; nums.size() != 0; i++) {
                    System.out.print(nums.remove(0) + " ");
                }
                System.out.println();
            }
            nums = null;
        }
        br.close();
    }

    public static int go(int pos) {
        if (pos == n) {
            return 0;
        }
        if (memo[pos] != -1) {
            return memo[pos];
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            if (i == pos || (i < n && (ws[i] <= w || hs[i] <= h))) {
                continue;
            }
            if (i != n && pos < n && (ws[pos] <= ws[i] || hs[pos] <= hs[i])) {
                continue;
            }
            int cur = 1 + go(i);
            if (cur > res) {
                next[pos] = i;
                res = cur;
            }
        }
        memo[pos] = res;
        if (res == 0) {
            return -100000;
        }
        return res;
    }
}
