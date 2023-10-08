package com.project.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory extends Factory {
    private static final Map<String, Command> commands = new HashMap<>();

    public static CommandFactory getInstance() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        CommandFactory factory = new CommandFactory();
        try (var in = classloader.getResourceAsStream("commands.properties");) {
            Properties props = new Properties();
            props.load(in);

            for (var name : props.stringPropertyNames()) {
                String clsName = props.getProperty(name);
                Class<?> aClass = Class.forName(clsName);
                var cmd = (Command) aClass.forName(clsName).getDeclaredConstructor().newInstance();
                Command proxyCommand = new Command() {
                    @Override
                    public void execute(String[] args, CalcContext ctx) {
                        cmd.execute(args, ctx);
                    }
                };
                commands.put(name, proxyCommand);
            }
            return factory;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
