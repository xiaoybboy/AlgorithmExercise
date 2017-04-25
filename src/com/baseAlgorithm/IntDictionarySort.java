package com.baseAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class IntDictionarySort {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			list.add(i);
		}

		Collections.sort(list, new IntDictionnaryComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
