package com.project.calc.commands;

import com.project.calc.CalcContext;
import com.project.calc.Command;
import com.project.calc.exception.ValidationException;

import java.util.Stack;

public class Sqrt implements Command {
    @Override
    public void execute(String[] args, CalcContext ctx) throws ValidationException {
        Stack<Double> stack = ctx.getStack();
        var v1 = stack.pop();
        if (v1 < 0){
            throw new ValidationException("Can not take square root of a negative number");
        }
        stack.add(Math.sqrt(v1));
    }
}
