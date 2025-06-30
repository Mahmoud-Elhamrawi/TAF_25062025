package Utils.TerminalUtil;

import Utils.Logs.LogClass;

public class TerminalUtil {

    public static void executeCommand(String... command) {

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            LogClass.error("fail to execute command " + e.getMessage());
        }


    }


}
