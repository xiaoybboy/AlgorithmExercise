package com.company.tencent;

/**
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
 * 
 * 请编写一个函数，使用递归的方法生成N位的格雷码。 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * 
 * 递归
 * 
 * //递归的思路就是n位gray码是由n-1位gray码生成，举个例子简单一些：
 * 
 * //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
 * 
 * //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
 * 
 * //添加1后需要顺序反向就变成(110,111,101,100) //组合在一起就是(000,001,011,010,110,111,101,100)
 * 
 * @author XIAO
 *
 */
public class GrayCode {
	public static String[] getGray(int n) {

		if (n == 0) {
			return null;
		}

		int m = (int) Math.pow(2, n);// 结果数组的长度
		String[] result = new String[m];

		if (n == 1) {
			result[0] = "0";
			result[1] = "1";
			return result;
		}

		String[] temp = getGray(n - 1);

		int j = 0;
		for (int i = 0; i < m; i++) {
			// 巧妙的利用j++和--j实现顺序反向
			if (i < m / 2) {
				result[i] = "0" + temp[j++];
			} else {
				result[i] = "1" + temp[--j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] result = GrayCode.getGray(5);
		for (String s : result) {
			System.out.println(s);
		}
	}
}
