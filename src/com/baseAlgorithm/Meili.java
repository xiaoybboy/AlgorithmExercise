package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-23 14:39
 **/
public class Meili {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] date = line.split(" ");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);

            boolean flag = false;
            if (year % 4 == 0) {
                flag = true;
            }

            int sumDay = 0;
            if (flag == false) {
                if (month == 1) {
                    sumDay = day;
                } else if (month == 2) {
                    sumDay = 31 + day;
                } else if (month == 3) {
                    sumDay = 59 + day;
                } else if (month == 4) {
                    sumDay = 90 + day;
                } else if (month == 5) {
                    sumDay = 120 + day;
                } else if (month == 6) {
                    sumDay = 151 + day;
                } else if (month == 7) {
                    sumDay = 181 + day;
                } else if (month == 8) {
                    sumDay = 212 + day;
                } else if (month == 9) {
                    sumDay = 243 + day;
                } else if (month == 10) {
                    sumDay = 273 + day;
                } else if (month == 11) {
                    sumDay = 304 + day;
                } else if (month == 12) {
                    sumDay = 334 + day;
                }
            } else {
                if (month == 1) {
                    sumDay = day;
                } else if (month == 2) {
                    sumDay = 31 + day;
                } else if (month == 3) {
                    sumDay = 60 + day;
                } else if (month == 4) {
                    sumDay = 91 + day;
                } else if (month == 5) {
                    sumDay = 121 + day;
                } else if (month == 6) {
                    sumDay = 152 + day;
                } else if (month == 7) {
                    sumDay = 182 + day;
                } else if (month == 8) {
                    sumDay = 213 + day;
                } else if (month == 9) {
                    sumDay = 244 + day;
                } else if (month == 10) {
                    sumDay = 274 + day;
                } else if (month == 11) {
                    sumDay = 305 + day;
                } else if (month == 12) {
                    sumDay = 335 + day;
                }
            }
            System.out.println(sumDay);
        }
    }

}
