package com.alvarezdqal;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;

public class TestPair {
    public static void main(String[] args) {

        Pair<String, String> firstPair = new Pair<String, String>("hello", "world");
        Pair<String, String> secondPair = new Pair<String, String>("hello", "world");

        System.out.println("FIRST equals SECOND: " + firstPair.equals(secondPair));

        System.out.println("FIRST CLASS: " + firstPair.getClass());
        System.out.println("SECOND CLASS: " + secondPair.getClass());

        System.out.println("FIRST HASH: " + firstPair.hashCode());
        System.out.println("SECOND HASH: " + secondPair.hashCode());

        HashMap<Pair<String, String>, String> map = new HashMap<Pair<String, String>, String>();
        map.put(firstPair, "FIRST");
        System.out.println("MAP[firstPair]: " + map.get(firstPair));
        System.out.println("MAP[secondPair]: " + map.get(secondPair));
    }
}
