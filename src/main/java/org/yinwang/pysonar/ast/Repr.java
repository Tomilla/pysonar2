package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.Analyzer;
import org.yinwang.pysonar.SuperState;


public class Repr extends Node {

    public Node value;


    public Repr(Node n, int start, int end) {
        super(start, end);
        this.value = n;
        addChildren(n);
    }


    @NotNull
    @Override
    public SuperState transform(SuperState s) {
        if (value != null) {
            transformExpr(value, s);
        }
        return Analyzer.self.builtins.BaseStr;
    }


    @NotNull
    @Override
    public String toString() {
        return "<Repr:" + value + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        if (v.visit(this)) {
            visitNode(value, v);
        }
    }
}
