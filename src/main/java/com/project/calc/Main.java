package com.project.calc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("input.txt");

        CalcContext ctx = new CalcContext();
        String[] cmaArgs = new String[0];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            CommandFactory factory = CommandFactory.getInstance();
            logger.debug("Factory is initialized");

            String arg;
            while ((arg = reader.readLine()) != null && !arg.isEmpty()) {
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
