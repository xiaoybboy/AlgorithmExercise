package com.company.qunar;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据父母血型，判断孩子可能的血型
 *
 * @author XIAO
 * @create 2017-09-07 15:11
 **/
public class BloodType {
    public String[] chkBlood(String father, String mother) {
        Map<String, String[]> bloodMap = new HashMap<>();
        bloodMap.put("OO", new String[]{"O"});
        bloodMap.put("AO", new String[]{"A", "O"});
        bloodMap.put("AA", new String[]{"A", "O"});
        bloodMap.put("AB", new String[]{"A", "AB", "B", "O"});
        bloodMap.put("AAB", new String[]{"A", "AB", "B"});
        bloodMap.put("BO", new String[]{"B", "O"});
        bloodMap.put("BB", new String[]{"B", "O"});
        bloodMap.put("BAB", new String[]{"A", "AB", "B"});
        bloodMap.put("ABO", new String[]{"A", "B"});
        bloodMap.put("ABAB", new String[]{"A", "AB", "B"});
        if (bloodMap.get(father + mother) == null) {
            return bloodMap.get(mother + father);
        }
        return bloodMap.get(father + mother);
    }
}
