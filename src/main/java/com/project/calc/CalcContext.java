package com.project.calc;

import java.util.*;

public class CalcContext {
    private Stack<Double> stack = new Stack<>();
    private Map<String, Double> consts = new HashMap<>();

    public Stack<Double> getStack() {
        return stack;
    }

    public Map<String, Double> getConstants() {
        return consts;
    }
}
