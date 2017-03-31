package com.offer2;

/**
 * 确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。 给定一个string
 * iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
 * 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 * 
 * @author XIAO
 *
 */
public class StringRepeat {
	// 暴力求解，双层循环，一一比较
	public boolean checkDifferent(String iniString) {
		for (int i = 0;i<iniString.length();i++) {
            for (int j = i+1;j<iniString.length();j++) {
                if (iniString.charAt(i) == iniString.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
