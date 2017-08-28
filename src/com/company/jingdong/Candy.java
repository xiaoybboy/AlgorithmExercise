package com.company.jingdong;

import java.util.Scanner;

/**
 * 某糖果公司专门生产儿童糖果，它最受儿童欢迎的糖果有A1、A2两个序列，均采用盒式包装。包装好的A1类糖果体积为一个存储单位，而包装好的A2类糖果体积
 * 正好是A1类的两倍。
 * <p>
 * 这两类糖果之所以广受儿童欢迎，是因为糖果中含有公司独家研发的魔幻因子。A1或A2序列中的糖果，看起来包装可能是一样的，但因为其中的魔幻因子含量
 * 不同被细分为不同的产品。
 * <p>
 * 临近传统节日，公司的糖果供不应求。作为一个精明的糖果分销商，小东希望能够借此大赚一笔，于是带着现金开着货车来公司提货。货车的容量是确定的，
 * 小东希望采购的糖果能够尽可能装满货车，且糖果的魔幻因子总含量最高。只要不超出货车容量，糖果总可以装入货车中。
 * <p>
 * 小东希望你能帮她解决这一问题。
 * <p>
 * 输入
 * <p>
 * 输入中有多组测试数据。每组测试数据的第一行有两个整数n和v，1<=n<=10^5, 1<=v<=10^9，n为可供选购糖果数量，v为货车的容量。
 * <p>
 * 随后n行为糖果的具体信息，第一行编号为1，第二行编号为2，以此类推，最后一行编号为n。每行包含两个整数ti和pi，1<=ti<=2,
 * 1<=pi<=10^4，ti为糖果所属的序列，1为A1、2为A2，pi则是其中的魔幻因子含量。
 * <p>
 * 样例输入
 * <p>
 * 3 2
 * <p>
 * 1 2
 * <p>
 * 2 7
 * <p>
 * 1 3
 * <p>
 * 输出
 * 对每组测试数据，先在单独的一行中输出能采购的糖果中的魔幻因子最高含量，之后在单独的行中按编号从小到大的顺序输出以空格分隔的糖果编号，若有多组糖果组合均能满足要求，输出编号最小的组。若没有糖果能够满足要求，则在第一行中输出0
 * ，第二行输出“No”。
 * 样例输出
 * <p>
 * 7 2
 *
 * @author XIAO
 */
public class Candy {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt(), v = cin.nextInt();

            int[] w = new int[n + 1];
            int[] p = new int[n + 1];
            int totalW = 0, totalP = 0;
            for (int i = 1; i <= n; ++i) {
                w[i] = cin.nextInt();
                p[i] = cin.nextInt();
                totalW += w[i];
                totalP += p[i];
            }

            if (totalW <= v) {
                System.out.println(totalP);
                boolean f = true;
                for (int i = 1; i <= n; ++i) {
                    if (f) {
                        f = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(i);
                }
                System.out.println();
            } else {

                int[][] dp = new int[n + 1][v + 1];
                int[] c = new int[n + 1];
                int ymin = Math.min(w[1] - 1, v);
                for (int j = 1; j <= ymin; ++j) {
                    dp[1][j] = 0;
                }
                for (int j = w[1]; j <= v; ++j) {
                    dp[1][j] = p[1];
                }

                for (int i = 2; i <= n; ++i) {
                    int min = Math.min(w[i] - 1, v);
                    for (int j = 1; j <= min; ++j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    for (int j = w[i]; j <= v; ++j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
                    }
                }

                if (dp[n][v] == 0) {
                    System.out.println(0);
                    System.out.println("No");
                } else {
                    System.out.println(dp[n][v]);
                    for (int i = n, j = v; i > 0; --i) {
                        if (dp[i][j] == dp[i - 1][j]) {
                            c[i] = 0;
                        } else {
                            c[i] = 1;
                            j -= w[i];
                        }
                    }
                    boolean f = true;
                    for (int i = 1; i <= n; ++i) {
                        if (c[i] == 1) {
                            if (f) {
                                f = false;
                            } else {
                                System.out.printf(" ");
                            }
                            System.out.print(i);
                        }
                    }
                    System.out.println();
                }
            }
        }
        cin.close();
    }
}