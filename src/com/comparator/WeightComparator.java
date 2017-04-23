package com.comparator;

import java.util.Comparator;

//
public class WeightComparator implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		// 重量小的排前面
		if (o1.getWeigth() != o2.getWeigth()) {
			return o1.getWeigth() - o2.getWeigth();
		} else {
			// 如果两者的重量相等，则价值大的排前面
			return o2.getValue() - o1.getValue();
		}
	}

}
