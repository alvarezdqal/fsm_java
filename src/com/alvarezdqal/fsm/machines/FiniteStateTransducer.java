package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateTransducer extends FiniteStateMachine {
    HashSet<String> outputAlphabet;
    HashMap<Pair<String, String>, String> ouputFunction;

    public FiniteStateTransducer(
            HashSet<String> inputAlphabet,
            HashSet<String> states,
            String initialState,
            HashMap<Pair<String, String>, String> stateTransitionFunction,
            HashSet<String> outputAlphabet,
            HashMap<Pair<String, String>, String> ouputFunction) {
        super(inputAlphabet, states, initialState, stateTransitionFunction);
        this.outputAlphabet = outputAlphabet;
        this.ouputFunction = ouputFunction;
    }
}
