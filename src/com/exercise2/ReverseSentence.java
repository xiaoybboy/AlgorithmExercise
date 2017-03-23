package com.exercise2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * “student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * 
 * @author XIAO
 *
 */
public class ReverseSentence {
	public String ReverseSentenceSolution(String str) {
		if (str == null) {
			return null;
		}
		if (str.trim().equals("")) {
			return str;
		}
		String string = str;
		String[] strings = string.split(" ");
		StringBuilder sBuilder = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			if (i == 0) {
				sBuilder.append(strings[i]);
			} else {
				sBuilder.append(strings[i]);
				sBuilder.append(" ");
			}
		}

		String string2 = sBuilder.toString();
		return string2;
	}
}
