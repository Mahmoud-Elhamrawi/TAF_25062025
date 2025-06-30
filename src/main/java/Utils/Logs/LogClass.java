package Utils.Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogClass {

    private LogClass() {
    }


    public static final String LogPath = "test-outputs/Logs/";

    //set logger

    public static Logger setLogger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }


    //get logger
    //info
    public static void info(String... msg) {
        setLogger().info(String.join(" ", msg));
    }

    //error
    public static void error(String... msg) {
        setLogger().error(String.join(" ", msg));
    }

    //debug
    public static void debug(String... msg) {
        setLogger().debug(String.join(" ", msg));
    }


}
