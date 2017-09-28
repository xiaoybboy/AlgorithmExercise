package com.baseAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-14 15:50
 **/
public class Haikang2 {
    public static void main(String[] args) {
        Haikang2 haikang = new Haikang2();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] strs = s.split(";");

            boolean correct = true;

            Map<Integer, String> department = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                String[] temp = strs[i].split(",");
                if (i == 0) {
                    if (Integer.parseInt(temp[0]) != 1 || Integer.parseInt(temp[3]) != 0) {
                        correct = false;
                        break;
                    }
                }
                if (temp[0].charAt(0) > '9' || temp[0].charAt(0) < '0') {
                    correct = false;
                    break;
                }

                if (temp[0].charAt(0) == temp[0].charAt(3)) {
                    correct = false;
                    break;
                }

                if (correct) {
                    department.put(Integer.parseInt(temp[0]), temp[1]);
                }
            }
            if (!correct) {
                System.out.println("incorrect data");
            } else {

            }
        }
    }
}
