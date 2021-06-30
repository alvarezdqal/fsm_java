package com.alvarezdqal.fsm.machines;

import com.alvarezdqal.fsm.helpers.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FiniteStateTransducer extends FiniteStateMachine {
    HashSet<String> outputAlphabet;
    HashMap<Pair<String, String>, String> transductionFunction;

    public FiniteStateTransducer(
            HashSet<String> inputAlphabet,
            HashSet<String> states,
            String initialState,
            HashMap<Pair<String, String>, String> stateTransitionFunction,
            HashSet<String> outputAlphabet,
            HashMap<Pair<String, String>, String> transductionFunction) {
        super(inputAlphabet, states, initialState, stateTransitionFunction);
        this.outputAlphabet = outputAlphabet;
        this.transductionFunction = transductionFunction;
    }

    public LinkedList<String> transduce(String[] seq) {

        LinkedList<String> transduction = new LinkedList<String>();
        String currentState = this.initialState;
        for (String elem : seq) {

            Pair<String, String> stateElemPair = new Pair<String, String>(currentState, elem);

            String outputLetter = this.transductionFunction.get(stateElemPair);
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

            String nextState = this.stateTransitionFunction.get(stateElemPair);
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
