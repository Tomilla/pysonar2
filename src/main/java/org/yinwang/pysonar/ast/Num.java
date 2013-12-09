package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.SuperState;
import org.yinwang.pysonar.types.NumType;


public class Num extends Node {

    public double n;
    public String complex = null;


    public Num(Object n, int start, int end) {
        super(start, end);
        if (n instanceof String) {
            this.complex = (String) n;
        } else {
            this.n = (Double) n;
        }
    }


    @NotNull
    @Override
    public SuperState transform(SuperState s) {
        String typename;
        if (complex != null) {
            return new NumType("complex");
        } else {
            if (Math.floor(n) == n) {
                typename = "int";
            } else {
                typename = "float";

            }
            return new NumType(typename, n);
        }
    }


    @NotNull
    @Override
    public String toString() {
        return "<Num:" + n + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        v.visit(this);
    }
}
