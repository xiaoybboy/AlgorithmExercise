package com.comparator;

import java.util.Comparator;

// 按照单位价值进行排序
public class PerValueComparator implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		// 单位价值高的在前面
		if (o1.getPervalue() != o2.getPervalue()) {
			return o2.getPervalue() - o1.getPervalue();// 按照单位价值降序排列
		} else {
			// 如果单位价值相同，重量小的排前面
			return o1.getWeigth() - o2.getWeigth();// 按照重量升序排列
		}
	}

}
