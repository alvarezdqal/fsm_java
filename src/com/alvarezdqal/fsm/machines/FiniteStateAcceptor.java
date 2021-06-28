package com.alvarezdqal.fsm.machines;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateAcceptor extends FiniteStateMachine {
    HashSet<String> finalStates;

    // Cant use same constructor with different args ?
    public FiniteStateAcceptor(
            HashSet<String> inputAlphabet,
            HashSet<String> states,
            String initialState,
            HashMap<String, String> stateTransitionFunction,
            HashSet<String> finalStates) {
        this.finalStates = finalStates;
    }
}
