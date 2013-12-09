package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.Analyzer;
import org.yinwang.pysonar.SuperState;


public class AugAssign extends Node {

    public Node target;
    public Node value;
    public Name op;


    public AugAssign(Node target, Node value, Name op, int start, int end) {
        super(start, end);
        this.target = target;
        this.value = value;
        this.op = op;
        addChildren(target, value);
    }


    @NotNull
    @Override
    public SuperState transform(SuperState s) {
        transformExpr(target, s);
        transformExpr(value, s);
        return Analyzer.self.builtins.Cont;
    }


    @NotNull
    @Override
    public String toString() {
        return "<AugAssign:" + target + " " + op + "= " + value + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        if (v.visit(this)) {
            visitNode(target, v);
            visitNode(value, v);
        }
    }
}
