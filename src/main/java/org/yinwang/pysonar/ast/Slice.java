package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.SuperState;
import org.yinwang.pysonar.types.ListType;


public class Slice extends Node {

    public Node lower;
    public Node step;
    public Node upper;


    public Slice(Node lower, Node step, Node upper, int start, int end) {
        super(start, end);
        this.lower = lower;
        this.step = step;
        this.upper = upper;
        addChildren(lower, step, upper);
    }


    @NotNull
    @Override
    public SuperState transform(SuperState s) {
        if (lower != null) {
            transformExpr(lower, s);
        }
        if (step != null) {
            transformExpr(step, s);
        }
        if (upper != null) {
            transformExpr(upper, s);
        }
        return new ListType();
    }


    @NotNull
    @Override
    public String toString() {
        return "<Slice:" + lower + ":" + step + ":" + upper + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        if (v.visit(this)) {
            visitNode(lower, v);
            visitNode(step, v);
            visitNode(upper, v);
        }
    }
}
