package com.company.jingdong;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 金融证券行业超好的薪酬待遇，吸引了大批的求职者前往应聘，小东也不例外，准备应聘一家证券公司。面试官为考察她的数据分析、处理和编码能力，
 * 
 * 为她准备了以下问题。股票交易中，委托是指股票交易者在证券公司买卖股票。每手委托包括一个委托单号i、价格pi、买入或卖出标记di及交易数量qi。
 * 
 * 交易处理中，需要把同类业务（买入或卖出）中相同价格的所有委托合并起来，形成一个清单。清单的第一部分为按价格降序排列的合并后的卖出委托，
 * 紧随其后的是按相同顺序排列的买入合并委托。证券公司比较关心的是比较抢手的s条合并委托信息，
 * 
 * 需要得到买入及卖出最抢手的s条合并委托。对于买入委托，抢手的是指报价高的委托，而卖出委托中报价低的较为抢手。若买或卖的合并委托数小于s条，
 * 
 * 则全部列入清单中。
 * 
 * 现在小东拿到的是n个委托，请你帮忙找出最抢手的s个合并委托。
 * 
 * 输入 输入有若干组，每组的第一行为两个正整数n和s（1<=n<=1000，1<=s<=50），分别表示委托数和最抢手的清单数，
 * 
 * 接下来的n行为具体的委托信息，每行包含3部分， 第一部分为一个字母‘B’或‘S’，表示买入或卖出，后两部分为两个整数p和q，表示报价和数量。
 * 
 * 任何卖出委托的报价都比买入委托的报价高。
 * 
 * 样例输入
 * 
 * 6 2
 * 
 * B 10 3
 * 
 * S 50 2
 * 
 * S 40 1
 * 
 * S 50 6
 * 
 * B 20 4
 * 
 * B 25 10
 * 
 * 输出
 * 
 * 输出不超过2s行合并委托清单，格式与输入相同。
 * 
 * 样例输出
 * 
 * S 50 8
 * 
 * S 40 1
 * 
 * B 25 10
 * 
 * B 20 4
 * 
 * @author XIAO
 *
 */
public class TradeBill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();// 委托数
			int s = sc.nextInt();// 抢手清单数

			TreeMap<Integer, Integer> buyList = new TreeMap<>();
			TreeMap<Integer, Integer> sellList = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				String buyOrSell = sc.next();
				if (buyOrSell.equals("B")) {
					int price = sc.nextInt();
					int num = sc.nextInt();
					if (buyList.containsKey(price)) {
						buyList.put(price, num + buyList.get(price));
					} else {
						buyList.put(price, num);
					}
				} else if (buyOrSell.equals("S")) {
					int price2 = sc.nextInt();
					int num2 = sc.nextInt();
					if (sellList.containsKey(price2)) {
						sellList.put(price2, num2 + sellList.get(price2));
					} else {
						sellList.put(price2, num2);
					}
				}
			}

			// 输出结果
			Iterator<Integer> it = sellList.descendingKeySet().iterator();// 反向遍历
			int count = 0;
			while (it.hasNext()) {
				int price = it.next();
				int num = sellList.get(price);
				System.out.println("S " + price + " " + num);
				count++;
				if (count == s) {
					break;
				}
			}

			// 输出结果
			Iterator<Integer> it2 = buyList.descendingKeySet().iterator();
			int count2 = 0;
			while (it2.hasNext()) {
				int price2 = it2.next();
				int num2 = buyList.get(price2);
				System.out.println("B " + price2 + " " + num2);
				count2++;
				if (count2 == s) {
					break;
				}
			}
		}
	}
}
