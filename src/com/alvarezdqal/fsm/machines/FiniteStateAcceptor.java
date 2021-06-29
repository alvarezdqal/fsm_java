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

    public boolean accepts(String[] seq) {

        String currentState = this.initialState;
        for (String elem : seq) {
            Pair<String, String> arg = new Pair<String, String>(currentState, elem);
            String nextState = this.stateTransitionFunction.get(arg);
            if (nextState == null) {
                throw new Error(
                        "The following encountered (state, input) pair is undefined in the state"
                                + " transition fuction: ("
                                + currentState
                                + ", "
                                + elem
                                + ")");
            }
            currentState = nextState;
            if (this.finalStates.contains(currentState)) {
                break;
            }
        }

        boolean accepts = this.finalStates.contains(currentState);
        return accepts;
    }
}
