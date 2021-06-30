package com.alvarezdqal;

import com.alvarezdqal.fsm.helpers.Pair;
import com.alvarezdqal.fsm.machines.FiniteStateAcceptor;

import java.util.HashMap;
import java.util.HashSet;

public class TestFiniteStateAcceptor {
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

        FiniteStateAcceptor<String, String> fsa =
                new FiniteStateAcceptor<String, String>(
                        inputAlphabet, states, initialState, stateTransitionFunction, finalStates);

        String[] seq = {"hello", "hello", "world", "hello", "there", "world", "world"};
        boolean accepts = fsa.accepts(seq);

        if (accepts) {
            System.out.println("The passed sequence is accepted.");
        } else {
            System.out.println("The passed sequence is not accepted.");
        }
    }
}
