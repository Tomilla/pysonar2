package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.Analyzer;
import org.yinwang.pysonar.SuperState;

import java.util.List;


public class Delete extends Node {

    public List<Node> targets;


    public Delete(List<Node> elts, int start, int end) {
        super(start, end);
        this.targets = elts;
        addChildren(elts);
    }


    @NotNull
    @Override
    public SuperState transform(@NotNull SuperState s) {
        for (Node n : targets) {
            transformExpr(n, s);
            if (n instanceof Name) {
                s.remove(n.asName().id);
            }
        }
        return Analyzer.self.builtins.Cont;
    }


    @NotNull
    @Override
    public String toString() {
        return "<Delete:" + targets + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        if (v.visit(this)) {
            visitNodeList(targets, v);
        }
    }
}
