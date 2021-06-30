package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateMachine<I, S> {
    HashSet<I> inputAlphabet;
    HashSet<S> states;
    S initialState;
    HashMap<Pair<S, I>, S> stateTransitionFunction;

    public FiniteStateMachine(
            HashSet<I> inputAlphabet,
            HashSet<S> states,
            S initialState,
            HashMap<Pair<S, I>, S> stateTransitionFunction) {
        this.inputAlphabet = inputAlphabet;
        this.states = states;
        this.initialState = initialState;
        this.stateTransitionFunction = stateTransitionFunction;
    }
}
