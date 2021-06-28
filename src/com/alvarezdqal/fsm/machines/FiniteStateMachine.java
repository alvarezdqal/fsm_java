package com.alvarezdqal.fsm.machines;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateMachine {
    HashSet<String> inputAlphabet;
    HashSet<String> states;
    String initialState;
    HashMap<String, String> stateTransitionFunction;

    public FiniteStateMachine(
            HashSet<String> inputAlphabet,
            HashSet<String> states,
            String initialState,
            HashMap<String, String> stateTransitionFunction) {
        this.inputAlphabet = inputAlphabet;
        this.states = states;
        this.initialState = initialState;
        this.stateTransitionFunction = stateTransitionFunction;
    }
}
