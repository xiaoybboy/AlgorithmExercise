package com.baseAlgorithm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-15 20:15
 **/
public class ZBJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = sc.next();
            }

            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(names[j])) {
                    map.put(names[j], 1);
                    System.out.println("OK");
                } else {
                    int count = map.get(names[j]);
                    String newname = names[j] + count;
                    System.out.println(newname);
                    map.put(names[j], count + 1);
                }
            }
        }
    }
}
