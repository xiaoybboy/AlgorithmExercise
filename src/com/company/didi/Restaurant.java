package com.company.didi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-04 9:32
 * <p>
 * 基本思路就是：桌子序列升序排列 ，客人按照预定花钱多少降序排序，然后贪心法从钱多的客人开始招呼。
 **/
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] deskC = new int[n];
        for (int i = 0; i < n; i++) {
            deskC[i] = sc.nextInt();
        }

        Arrays.sort(deskC);

        PriorityQueue<Customer> queue = new PriorityQueue<>(); // 将客人按消费额降序加入优先级队列
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (b <= deskC[n - 1]) {// 如果人数小于桌子最大容纳量,加入队列
                queue.add(new Customer(b, c));
            }
        }

        boolean[] visited = new boolean[n]; // 记录桌子是否被占用
        long sum = 0; // 记录总盈利
        int count = 0; // 记录已使用的桌子数

        while (!queue.isEmpty()) {
            Customer customer = queue.poll();//取出消费额最高的
            for (int i = 0; i < n; i++) { // 为客人分配桌子
                if (customer.peopleCount <= deskC[i] && !visited[i]) {
                    sum += customer.moneyCount;
                    visited[i] = true;
                    count++;
                    break;
                }
            }
            if (count == n) break;
        }
        System.out.println(sum);
    }

    static class Customer implements Comparable<Customer> {
        private int peopleCount;
        private int moneyCount;

        public Customer(int peopleCount, int moneyCount) {
            this.peopleCount = peopleCount;
            this.moneyCount = moneyCount;
        }

        @Override
        public int compareTo(Customer o) {
            if (o.moneyCount > this.moneyCount) return 1;
            else if (o.moneyCount < this.moneyCount) return -1;
            return 0;
        }
    }
}
