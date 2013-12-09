package org.yinwang.pysonar;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class SuperState implements Iterable<State> {

    private Collection<State> states = new ArrayList<>();


    public SuperState() {
    }


    public void add(State s) {
        states.add(s);
    }


    public void addAll(Collection<State> states) {
        states.addAll(states);
    }


    @Override
    public Iterator<State> iterator() {
        return states.iterator();
    }
}
