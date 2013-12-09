package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.Analyzer;
import org.yinwang.pysonar.SuperState;
import org.yinwang.pysonar.types.Type;


public class TryFinally extends Node {

    public Block body;
    public Block finalbody;


    public TryFinally(Block body, Block orelse, int start, int end) {
        super(start, end);
        this.body = body;
        this.finalbody = orelse;
        addChildren(body, orelse);
    }


    @NotNull
    @Override
    public SuperState transform(SuperState s) {
        Type tFinal = Analyzer.self.builtins.unknown;
        if (body != null) {
            transformExpr(body, s);
        }
        if (finalbody != null) {
            tFinal = transformExpr(finalbody, s);
        }
        return tFinal;
    }


    @NotNull
    @Override
    public String toString() {
        return "<TryFinally:" + body + ":" + finalbody + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        if (v.visit(this)) {
            visitNode(body, v);
            visitNode(finalbody, v);
        }
    }
}
