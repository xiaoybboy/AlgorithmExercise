package com.baseAlgorithm;

import java.util.Scanner;

public class Main {

	/* 请完成下面这个函数，实现题目要求的功能 */
	/* 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
	/****************************** 开始写代码 ******************************/
	static void quickSortInputOutput(int[] array, int low, int high) {
		int n = array.length;
		/*
		 * Node tail = new Node(Integer.parseInt(numbers[n-1]), null);//尾节点 Node
		 * temp = tail;
		 * 
		 * 
		 * LinkList list = new LinkList(null, tail);
		 */
		int p = partion(array, 0, n);
		quickSortInputOutput(array, 0, p);
		quickSortInputOutput(array, p + 1, n - 1);
	}

	public static int partion(int[] list, int low, int high) {
		int key = list[low];
		while (low < high) {
			while (low < high && list[high] >= key) {
				high--;
			}
			list[low] = list[high];
			while (low < high && list[low] <= key) {
				low++;
			}
			list[high] = list[low];
		}
		list[low] = key;
		return low;
	}

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String res;

		String _str;
		try {
			_str = in.nextLine();
		} catch (Exception e) {
			_str = null;
		}

		String[] numberstr = _str.split(",");
		int[] numbers = new int[numberstr.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numberstr[i]);
		}

		int n = numbers.length;
		/**
		 * 构建单链表
		 */
		Node head = null;
		Node tail = new Node(numbers[n - 1], null);// 尾节点
		LinkList list = new LinkList(null, tail);

		Node temp = tail;// 下一个Node节点
		for (int i = n - 2; i >= 0; i--) {
			if (i == 0) {
				head = new Node(numbers[0], temp);
			} else {
				Node node = new Node(numbers[i], temp);
				temp = node;
			}
		}
		list.head = head;

		// 对单链表进行排序

		// quickSortInputOutput(numbers, 0, numbers.length);
		StringBuffer buffer = new StringBuffer();

		// 构建输出字符串
		Node node = head;
		while (node != null) {
			if (node != tail) {
				buffer.append(String.valueOf(node.data) + ",");
			} else {
				buffer.append(String.valueOf(node.data));
			}

		}
		System.out.println(buffer.toString());
	}
}

class Node {
	public int data;
	public Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

class LinkList {
	public Node head;
	public Node tail;

	public LinkList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

}
