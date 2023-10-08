package com.project.calc.commands;

import com.project.calc.CalcContext;
import com.project.calc.Command;

public class Define implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) {
        ctx.getConstants().put(args[1], Double.valueOf(args[2]));
    }
}
