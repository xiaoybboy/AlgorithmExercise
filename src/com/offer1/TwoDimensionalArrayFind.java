package com.offer1;

import java.awt.RadialGradientPaint;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 思路：从数组的左下角或者右上角开始查找。
 * 
 * 首先选取数组右上角的数字，如果该数字等于要查找的数字，则查找结束；
 * 
 * 如果要查找的数字大于该数字，剔除这个数字所在的行。 如果要查找的数字小于该数字，剔除这个数字所在的列，
 * 
 * 这样每一步都可以剔除一行或一列，查找的速度比较快。 当然也可以选择左下角的数字，思路同上。
 * 
 * 这样子查找的话，每次能比较一行或者一列，效率就快了。
 * 
 * @author XIAO
 *
 */
public class TwoDimensionalArrayFind {
	// 比较右上角的数字与target大小
	public boolean Find1(int target, int[][] array) {

		int maxrow = array.length - 1;
		int maxcol = array[0].length - 1;
		int row = 0;

		while (row <= maxrow && maxcol >= 0) {
			// 选择右上角的数字与target进行比较
			if (target == array[row][maxcol])
				return true;
			else if (target > array[row][maxcol])
				row++;// target一定在row行的下面行
			else
				maxcol--;// target一定在column列的左边
		}
		return false;
	}

	// 比较左下角的数字与target大小
	public boolean Find2(int target, int[][] array) {

		int maxrow = array.length - 1;
		int maxcol = array[0].length - 1;
		int col = 0;

		while (maxrow >= 0 && col <= maxcol) {
			if (target == array[maxrow][col]) {
				return true;
			} else if (target > array[maxrow][col]) {
				col++;
			} else {
				maxrow--;
			}
		}
		return false;
	}
}
