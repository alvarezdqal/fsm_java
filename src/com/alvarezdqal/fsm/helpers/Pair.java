package com.alvarezdqal.fsm.helpers;

import java.util.Objects;

public final class Pair<X, Y> {
    private final X first;
    private final Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return this.first;
    }

    public Y getSecond() {
        return this.second;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            Pair otherPair = (Pair) obj;
            boolean firstsMatch = this.first == otherPair.first;
            boolean secondsMatch = this.second == otherPair.second;
            return firstsMatch && secondsMatch;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(this.first, this.second);
        return hash;
    }
}
