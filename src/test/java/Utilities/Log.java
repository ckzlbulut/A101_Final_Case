package Utilities;

import org.apache.log4j.Logger;

public class Log {
    // This class created for the basic log method.
    public static Logger logger = Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);

    }

}
