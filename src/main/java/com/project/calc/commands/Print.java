package com.project.calc.commands;

import com.project.calc.CalcContext;
import com.project.calc.Command;

public class Print implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        System.out.println(ctx.getStack().getFirst());
    }

}
