package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateAcceptor extends FiniteStateMachine {
    HashSet<String> finalStates;

    public FiniteStateAcceptor(
            HashSet<String> inputAlphabet,
            HashSet<String> states,
            String initialState,
            HashMap<Pair<String, String>, String> stateTransitionFunction,
            HashSet<String> finalStates) {
        super(inputAlphabet, states, initialState, stateTransitionFunction);
        this.finalStates = finalStates;
    }
}
