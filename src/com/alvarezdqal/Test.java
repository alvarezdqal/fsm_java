package com.alvarezdqal;

import com.alvarezdqal.fsm.helpers.Pair;
import com.alvarezdqal.fsm.machines.FiniteStateAcceptor;

import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

        HashSet<String> inputAlphabet = new HashSet<String>();
        inputAlphabet.add("hello");
        inputAlphabet.add("there");
        inputAlphabet.add("world");

        HashSet<String> states = new HashSet<String>();
        states.add("i");
        states.add("a");
        states.add("b");
        states.add("t1");
        states.add("t2");

        String initialState = "i";

        HashMap<Pair<String, String>, String> stateTransitionFunction =
                new HashMap<Pair<String, String>, String>();
        stateTransitionFunction.put(new Pair<String, String>("i", "hello"), "i");
        stateTransitionFunction.put(new Pair<String, String>("i", "there"), "a");
        stateTransitionFunction.put(new Pair<String, String>("i", "world"), "b");
        stateTransitionFunction.put(new Pair<String, String>("a", "hello"), "t1");
        stateTransitionFunction.put(new Pair<String, String>("a", "there"), "t2");
        stateTransitionFunction.put(new Pair<String, String>("a", "world"), "a");
        stateTransitionFunction.put(new Pair<String, String>("b", "hello"), "b");
        stateTransitionFunction.put(new Pair<String, String>("b", "there"), "i");
        stateTransitionFunction.put(new Pair<String, String>("b", "world"), "t2");

        HashSet<String> finalStates = new HashSet<String>();
        finalStates.add("t1");
        finalStates.add("t2");

        FiniteStateAcceptor fsa =
                new FiniteStateAcceptor(
                        inputAlphabet, states, initialState, stateTransitionFunction, finalStates);

        System.out.println(fsa);
    }
}
