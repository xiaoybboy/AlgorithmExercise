package com.company.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。
 * 重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 *
 * @author XIAO
 * @create 2017-09-07 13:41
 **/
public class RemoveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                list.add(i);
            while (list.size() != 1) {
                // 从0开始list移除一次,i再加一次,i始终指向奇数位
                for (int i = 0; i < list.size(); i = i + 1)
                    list.remove(i);//list移除一次，list的长度减1，所以是i=i+1
            }
            System.out.println(list.get(0));
        }
    }
}
