package com.project.calc.commands;

import com.project.calc.CalcContext;
import com.project.calc.Command;

public class Push implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        if (Character.isAlphabetic(args[1].charAt(0))){
            ctx.getStack().add(ctx.getConstants().get(args[1]));
        } else {
            ctx.getStack().add(Double.valueOf(args[1]));
        }
    }
}
