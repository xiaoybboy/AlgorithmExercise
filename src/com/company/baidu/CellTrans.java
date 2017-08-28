package com.company.baidu;

import java.util.Scanner;

/**
 * <p>
 * 小B最近对电子表格产生了浓厚的兴趣，她觉得电子表格很神奇，功能远比她想象的强大。她正在研究的是单元格的坐标编号，她发现表格单元一般
 * 是按列编号的，第1列编号为A，第2列为B，以此类推，第26列为Z。之后是两位字符编号的，第27列编号为AA，第28列为AB，第52列编号为AZ。
 * 之后则是三位、四位、五位……字母编号的，规则类似。
 * </p>
 * 表格单元所在的行则是按数值从1开始编号的，表格单元名称则是其列编号和行编号的组合，如单元格BB22代表的单元格为54列中第22行的单元格。
 * 小B感兴趣的是，编号系统有时也可以采用RxCy的规则，其中x和y为数值，表示单元格位于第x行的有第y列。上述例子中的单元格采用这种编码体
 * 系时的名称为R22C54。
 * 
 * 小B希望快速实现两种表示之间的转换，请你帮忙设计程序将一种方式表示的坐标转换为另一种方式。
 * 
 * 输入
 * 输入的第一行为一个正整数T，表示有T组测试数据（1<=T<=10^5）。随后的T行中，每行为一组测试数据，为一种形式表示的单元格坐标。保证所
 * 有的坐标都是正确的，且所有行列坐标值均不超过10^6。
 * 样例输入
 * 
 * 2
 * 
 * R23C55
 * 
 * BC23
 * 
 * 输出
 *
 * 对每组测试数据，单独输出一行，为单元格坐标的另一种表示形式。 样例输出 BC23 R23C55
 * </p>
 * @author XIAO
 *
 */
public class CellTrans {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String strs[] = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = sc.next();
		}
		for (int i = 0; i < n; i++) {
			System.out.println(change(strs[i]));
		}
		sc.close();
	}

	public static String change(String s) {
		if (s.matches("R\\d+C\\d+")) {
			return changeToBsc(s);
		}
		return changeToRC(s);
	}

	public static String changeToBsc(String s) {
		int col = 0, row = 0;
		boolean isRow = true;
		for (char c : s.toCharArray()) {
			if (c <= '9') {
				if (isRow)
					row = row * 10 + c - '0';
				else
					col = col * 10 + c - '0';
			} else {
				isRow = c == 'R';
			}
		}
		String col_s = "";
		while (col > 0) {
			int t = (col - 1) % 26 + 1;
			col_s = (char) (t + 'A' - 1) + col_s;
			col = (col - 1) / 26;
		}
		return col_s + row;
	}

	public static String changeToRC(String s) {
		int col = 0, row = 0;
		for (char c : s.toCharArray()) {
			if (c >= 'A') {
				col = col * 26 + c - 'A' + 1;
			} else {
				row = row * 10 + c - '0';
			}
		}
		return "R" + row + "C" + col;
	}

}
