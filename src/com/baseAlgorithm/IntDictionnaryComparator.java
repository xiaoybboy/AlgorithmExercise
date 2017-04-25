package com.baseAlgorithm;

import java.util.Comparator;

public class IntDictionnaryComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		String s1 = String.valueOf(o1);
		String s2 = String.valueOf(o2);

		for (int i = 0;; i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1;
			} else if (s1.charAt(i) < s2.charAt(i)) {
				return -1;
			} else {
				if (i == s1.length() - 1 && i < s2.length() - 1) {
					return -1;
				} else if (i == s2.length() - 1 && i < s1.length() - 1) {
					return 1;
				} else if (i == s2.length() - 1 && i == s1.length() - 1) {
					return 0;
				}
			}
		}
	}

}
