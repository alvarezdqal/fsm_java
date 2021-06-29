package com.alvarezdqal;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        Pair<String, String> firstPair = new Pair<String, String>("hello", "world");
        Pair<String, String> secondPair = new Pair<String, String>("hello", "world");

        HashMap<Pair<String, String>, String> map = new HashMap<Pair<String, String>, String>();
        map.put(firstPair, "FIRST");
        System.out.println(map.get(secondPair));
    }
}
