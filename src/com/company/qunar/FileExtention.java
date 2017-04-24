package com.company.qunar;

import java.util.Scanner;

/**
 * Please create a function to extract the filename extension from the given
 * path,return the extracted filename extension or null if none.
 * 
 * 输入
 * 
 * 输入数据为一个文件路径
 * 
 * 样例输入 Abc/file.txt
 * 
 * 输出
 * 
 * 对于每个测试实例，要求输出对应的filename extension
 * 
 * 样例输出 txt
 * 
 * @author XIAO
 *
 */
public class FileExtention {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int index = str.lastIndexOf(".");
		String extension = str.substring(index + 1);
		System.out.println(extension);
	}

}
