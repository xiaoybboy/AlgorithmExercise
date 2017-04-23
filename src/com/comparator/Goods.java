package com.comparator;

public class Goods {
	// 属性
	private int num;
	private int weigth;
	private int value;

	public Goods(int num, int weigth, int value) {
		super();
		this.num = num;
		this.weigth = weigth;
		this.value = value;
	}

	// 定义方法，获得单位价值
	public int getPervalue() {
		int perValue = this.value / this.weigth;
		return perValue;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Goods [num=" + num + ", weigth=" + weigth + ", value=" + value + "]";
	}

}
