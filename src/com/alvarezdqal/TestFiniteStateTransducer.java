package com.alvarezdqal;

import com.alvarezdqal.fsm.helpers.Pair;
import com.alvarezdqal.fsm.machines.FiniteStateTransducer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class TestFiniteStateTransducer {
    public static void main(String[] args) {

        HashSet<String> inputAlphabet = new HashSet<String>();
        inputAlphabet.add("a");
        inputAlphabet.add("b");
        inputAlphabet.add("c");

        HashSet<String> states = new HashSet<String>();
        states.add("0");
        states.add("1");
        states.add("2");

        String initialState = "0";

        HashMap<Pair<String, String>, String> stateTransitionFunction =
                new HashMap<Pair<String, String>, String>();
        stateTransitionFunction.put(new Pair<String, String>("0", "a"), "0");
        stateTransitionFunction.put(new Pair<String, String>("0", "b"), "1");
        stateTransitionFunction.put(new Pair<String, String>("0", "c"), "2");
        stateTransitionFunction.put(new Pair<String, String>("1", "a"), "2");
        stateTransitionFunction.put(new Pair<String, String>("1", "b"), "1");
        stateTransitionFunction.put(new Pair<String, String>("1", "c"), "0");

        HashSet<String> outputAlphabet = new HashSet<String>();
        states.add("i");
        states.add("j");
        states.add("k");
        states.add("x");
        states.add("y");
        states.add("z");

        HashMap<Pair<String, String>, String> transductionFunction =
                new HashMap<Pair<String, String>, String>();
        transductionFunction.put(new Pair<String, String>("0", "a"), "i");
        transductionFunction.put(new Pair<String, String>("0", "b"), "j");
        transductionFunction.put(new Pair<String, String>("0", "c"), "k");
        transductionFunction.put(new Pair<String, String>("1", "a"), "x");
        transductionFunction.put(new Pair<String, String>("1", "b"), "y");
        transductionFunction.put(new Pair<String, String>("1", "c"), "z");

        FiniteStateTransducer<String, String, String> fst =
                new FiniteStateTransducer<String, String, String>(
                        inputAlphabet,
                        states,
                        initialState,
                        stateTransitionFunction,
                        outputAlphabet,
                        transductionFunction);

        String[] seq = {"b", "c", "b", "a"};
        LinkedList<String> transduction = fst.transduce(seq);

        System.out.println(transduction.toString());
    }
}
