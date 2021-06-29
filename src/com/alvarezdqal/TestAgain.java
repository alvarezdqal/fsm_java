package com.alvarezdqal;

import java.util.HashMap;

public class TestAgain {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("david", 23);
        map.put("kim", 23);
        map.put("abbie", 22);

        System.out.println("abbie: " + map.get("abbie"));
        System.out.println("bob: " + map.get("bob"));
    }
}
