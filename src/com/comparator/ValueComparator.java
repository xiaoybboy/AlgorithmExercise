package com.comparator;

import java.util.Comparator;

//按照价值排序
public class ValueComparator implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		if (o1.getValue() != o2.getValue()) {
			return o1.getValue() - o2.getValue();// 按照价值升序排列
		} else {
			return o1.getWeigth() - o2.getWeigth();// 价值相等 则按照重量升序排列
		}
	}

}
