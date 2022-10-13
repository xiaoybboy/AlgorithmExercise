package com.top200;

import java.util.ArrayList;
import java.util.List;

/**
 * 求字符串的全排列
 */
public class Permutation {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abc";
        permutation_fun(s.toCharArray(),0);
    }

    private static void permutation_fun(char[] strArray,int begin){
        if (begin == strArray.length){
            System.out.print(strArray);
            result.add(new String(strArray));
            return;
        }

        for (int i = begin;i<strArray.length;i++){
            /*将第一个字符和后面的字符依次交换*/
            swap(strArray,i,begin);
            /*对于第一个字符后面的字符，依次和后面的字符进行交换*/
            permutation_fun(strArray,begin+1);
            /*由于还要交换其他位到该位，因此要将字符串恢复到未交换的时候的样子*/
            swap(strArray,i,begin);
        }
    }

     private static void swap(char[] inputStr, int i, int j) {
        char temp = inputStr[i];
        inputStr[i] = inputStr[j];
        inputStr[j] = temp;
    }
}
