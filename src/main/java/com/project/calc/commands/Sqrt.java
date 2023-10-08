package com.project.calc.commands;

import com.project.calc.CalcContext;
import com.project.calc.Command;
import java.util.Deque;

public class Sqrt implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        Deque<Double> stack = ctx.getStack();
        var v1 = stack.removeFirst();
        stack.add(Math.sqrt(v1));
    }
}
