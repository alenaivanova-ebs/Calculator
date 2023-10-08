package com.project.calc;

import com.project.calc.exception.ValidationException;

public interface Command {
    void execute( String[] args, CalcContext ctx) throws ValidationException;
}
