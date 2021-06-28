package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateMachine {
    HashSet<String> inputAlphabet;
    HashSet<String> states;
    String initialState;
    HashMap<Pair<String, String>, String> stateTransitionFunction;

    public FiniteStateMachine(
            HashSet<String> inputAlphabet,
            HashSet<String> states,
            String initialState,
            HashMap<Pair<String, String>, String> stateTransitionFunction) {
        this.inputAlphabet = inputAlphabet;
        this.states = states;
        this.initialState = initialState;
        this.stateTransitionFunction = stateTransitionFunction;
    }
}
