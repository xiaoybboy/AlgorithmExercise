package com.baseAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-14 15:43
 **/
public class HaiKang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] strs = s.split(",");
            boolean correct = true;

            int N = Integer.parseInt(strs[0]);
            if (N < 3) {
                correct = false;
            }
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
            try {
                format.format(new Date(strs[1]));
                format.format(new Date(strs[2]));
            } catch (Exception e) {
                correct = false;
            }

            if (!correct) {
                System.out.println("incorrect data");
            }
        }
    }
}
