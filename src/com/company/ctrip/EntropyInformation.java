package com.company.ctrip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 计算给定字符的二进制信息熵（香农熵）（如有小数，保留至小数位后7位）
 *
 * @author XIAO
 */
public class EntropyInformation {

    public static double log(double x, int base) {
        return Math.log(x) / Math.log(base);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().trim();
        s = s.replaceAll("\\p{Z}", "");
        double n = s.length();
        double entropy = 0;
        if (s != null && !"".equals(s) && n != 0) {
            HashMap<Character, Integer> m = new HashMap<>();
            for (Character c : s.toCharArray()) {
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                } else {
                    m.put(c, 1);
                }
            }

            for (Map.Entry<Character, Integer> t : m.entrySet()) {
                double p = t.getValue() / n;
                entropy += p * -log(p, 2);
            }
        }
        String value = String.valueOf(entropy);
        int len = value.length() - value.indexOf(".");
        if (len > 7)
            System.out.printf("%.7f", entropy);
        else
            System.out.println(entropy);
    }
}
