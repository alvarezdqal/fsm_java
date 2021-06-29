package com.alvarezdqal.fsm.helpers;

public class Pair<X, Y> {
    X first;
    Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Pair<X, Y> otherPair) {
        boolean firstsMatch = this.first == otherPair.first;
        boolean secondsMatch = this.second == otherPair.second;
        return firstsMatch && secondsMatch;
    }
}
