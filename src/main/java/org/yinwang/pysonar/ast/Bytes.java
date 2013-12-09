package org.yinwang.pysonar.ast;

import org.jetbrains.annotations.NotNull;
import org.yinwang.pysonar.Analyzer;
import org.yinwang.pysonar.SuperState;


public class Bytes extends Node {

    private Object value;


    public Bytes(@NotNull Object value, int start, int end) {
        super(start, end);
        this.value = value.toString();
    }


    public Object getStr() {
        return value;
    }


    @NotNull
    @Override
    public SuperState transform(SuperState s) {
        return Analyzer.self.builtins.BaseStr;
    }


    @NotNull
    @Override
    public String toString() {
        return "<Bytpes: " + value + ">";
    }


    @Override
    public void visit(@NotNull NodeVisitor v) {
        v.visit(this);
    }
}
