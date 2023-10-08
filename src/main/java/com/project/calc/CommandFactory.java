package com.project.calc;

import com.project.calc.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory extends Factory {

    private static Logger logger = LogManager.getLogger(Factory.class);
    private static final Map<String, Command> commands = new HashMap<>();

    public static CommandFactory getInstance() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        CommandFactory factory = new CommandFactory();
        try (var in = classloader.getResourceAsStream("commands.properties");) {
            Properties props = new Properties();
            props.load(in);
            logger.info("File with commands is loaded");

            for (var name : props.stringPropertyNames()) {
                String clsName = props.getProperty(name);
                Class<?> aClass = Class.forName(clsName);
                var cmd = (Command) Class.forName(clsName).getDeclaredConstructor().newInstance();
                logger.info("Command {} is initialized",cmd);

                Command proxyCommand = new Command() {
                    @Override
                    public void execute(String[] args, CalcContext ctx) {
                        try {
                            cmd.execute(args, ctx);
                        } catch (ValidationException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                commands.put(name, proxyCommand);
                logger.info("Commands were loaded");
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
