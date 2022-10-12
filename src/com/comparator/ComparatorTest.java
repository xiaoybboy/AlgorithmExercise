package com.comparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author XIAO
 *
 */
public class ComparatorTest {
	public static void main(String[] args) {
		ArrayList<Goods> list = new ArrayList<Goods>();

		list.add(new Goods(1, 20, 30));
		list.add(new Goods(2, 8, 10));
		list.add(new Goods(3, 10, 15));
		list.add(new Goods(4, 30, 35));
		list.add(new Goods(5, 5, 8));
		list.add(new Goods(6, 30, 45));
		list.add(new Goods(7, 18, 10));
		list.add(new Goods(8, 4, 5));

		System.out.println("----------  before sort  ----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("----------  按照单位价值进行排序  ----------");
		Collections.sort(list, new PerValueComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("----------  按照重量进行排序  ----------");
		Collections.sort(list, new WeightComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
