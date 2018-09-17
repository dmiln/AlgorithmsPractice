package javacore.week4;

import java.util.logging.*;

public class LoggerTest {

    private static void configureLogging() {
        final Logger LOGGERA = Logger.getLogger("org.stepic.java.logging.ClassA");
        final Logger LOGGERB = Logger.getLogger("org.stepic.java.logging.ClassB");
        final Logger LOGGERorgstepicjava = Logger.getLogger("org.stepic.java");


        LOGGERA.setLevel(Level.ALL);
        LOGGERB.setLevel(Level.WARNING);

        LOGGERorgstepicjava.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        LOGGERorgstepicjava.addHandler(consoleHandler);


        XMLFormatter xmlFormatter = new XMLFormatter();
        consoleHandler.setFormatter(xmlFormatter);
    }
}
