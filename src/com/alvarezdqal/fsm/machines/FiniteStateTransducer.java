package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FiniteStateTransducer<I, S, O> extends FiniteStateMachine<I, S> {
    HashSet<O> outputAlphabet;
    HashMap<Pair<S, I>, O> transductionFunction;

    public FiniteStateTransducer(
            HashSet<I> inputAlphabet,
            HashSet<S> states,
            S initialState,
            HashMap<Pair<S, I>, S> stateTransitionFunction,
            HashSet<O> outputAlphabet,
            HashMap<Pair<S, I>, O> transductionFunction) {
        super(inputAlphabet, states, initialState, stateTransitionFunction);
        this.outputAlphabet = outputAlphabet;
        this.transductionFunction = transductionFunction;
    }

    public LinkedList<O> transduce(I[] seq) {

        LinkedList<O> transduction = new LinkedList<O>();
        S currentState = this.initialState;
        for (I elem : seq) {

            Pair<S, I> stateElemPair = new Pair<S, I>(currentState, elem);

            O outputLetter = this.transductionFunction.get(stateElemPair);
            if (outputLetter == null) {
                throw new Error(
                        "The following encountered (state, input) pair is undefined in the"
                                + " transduction fuction: ("
                                + currentState
                                + ", "
                                + elem
                                + ")");
            }
            transduction.add(outputLetter);

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
        }

        return transduction;
    }
}
