package com.company.sogou;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			list.add(String.valueOf(i));
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
