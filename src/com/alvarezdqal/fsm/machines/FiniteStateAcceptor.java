package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class FiniteStateAcceptor<I, S> extends FiniteStateMachine<I, S> {
    HashSet<S> finalStates;

    public FiniteStateAcceptor(
            HashSet<I> inputAlphabet,
            HashSet<S> states,
            S initialState,
            HashMap<Pair<S, I>, S> stateTransitionFunction,
            HashSet<S> finalStates) {
        super(inputAlphabet, states, initialState, stateTransitionFunction);
        this.finalStates = finalStates;
    }

    public boolean accepts(I[] seq) {

        S currentState = this.initialState;
        for (I elem : seq) {
            Pair<S, I> stateElemPair = new Pair<S, I>(currentState, elem);
            S nextState = this.stateTransitionFunction.get(stateElemPair);
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
