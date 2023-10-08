package com.project.calc;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("input.txt");

        CalcContext ctx = new CalcContext();
        String[] cmaArgs = new String[0];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            CommandFactory factory = CommandFactory.getInstance();
            String arg;

            while (null != (arg = reader.readLine()) && !arg.isEmpty()) {
                cmaArgs = arg.split(" ");
                var cmd = factory.getCommand(cmaArgs[0]);
                if (cmd == null) {
                    continue;
                }
                cmd.execute(cmaArgs, ctx);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
