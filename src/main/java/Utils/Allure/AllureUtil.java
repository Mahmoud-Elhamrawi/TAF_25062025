package Utils.Allure;

import Utils.FileUtils.FileUtil;
import Utils.Logs.LogClass;
import Utils.TerminalUtil.TerminalUtil;
import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static Utils.DataUtils.ReadPropertyFile.getPropertyKey;

public class AllureUtil {


    // add screenshot
    public static void addScreenshotToReport(String screenshotName, String screenshotPath) {
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
            LogClass.info("screenshot added to report");
        } catch (Exception e) {
            LogClass.error("fail to add screenshot to report " + e.getMessage());
        }

    }


    //add log file
    public static void addLogFileToReport() {
        try {
            File lastFile = FileUtil.getLastFile(FileUtil.logsPath);
            Allure.addAttachment("log file", Files.readString(lastFile.toPath()));
            LogClass.info("log file added to report");

        } catch (Exception e) {
            LogClass.error("fail to add log file to report " + e.getMessage());
        }
    }

    // C:\Users\Mahmoud\scoop\apps\allure\2.34.1\bin
    // C:\Users\Mahmoud\.m2\repository\allure\2.34.1\bin
    //generate report
    static String USER_HOME = System.getProperty("user.home");
    static String ALLURE_RESULT_PATH = "test-outputs/target/allure-results/";
    static String ALLURE_REPORT_PATH = "test-outputs/allure-report/";
    static String ALLURE_BIN_PATH = USER_HOME + File.separator + ".m2" + File.separator + "repository" + File.separator + "allure" + File.separator + "2.34.1" + File.separator + "bin" + File.separator + "allure";

    public static void generateReport() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                String WIN = ALLURE_BIN_PATH + ".bat";
                TerminalUtil.executeCommand(WIN, "generate", ALLURE_RESULT_PATH, "-o", ALLURE_REPORT_PATH, "--clean", "--single-file");
                LogClass.info("report generated on windows");
            } else {
                TerminalUtil.executeCommand(ALLURE_BIN_PATH, "generate", ALLURE_RESULT_PATH, "-o", ALLURE_REPORT_PATH, "--clean", "--single-file");
                LogClass.info("report generated on linux");
            }
        } catch (Exception e) {
            LogClass.error("fail to generate report " + e.getMessage());
        }

    }


    //open report
    public static void openReport() {
        String ALLUREFolder = ALLURE_REPORT_PATH + File.separator + "index.html";

        if (Objects.equals(getPropertyKey("openAllure"), "true")) {


            try {
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    TerminalUtil.executeCommand("cmd", "/c", "start", ALLUREFolder);
                    LogClass.info("report opened on windows");
                } else {
                    TerminalUtil.executeCommand("xdg-open", ALLUREFolder);
                    LogClass.info("report opened on linux");
                }
            } catch (Exception e) {
                LogClass.error("fail to open report " + e.getMessage());
            }


        } else {
            LogClass.info("report not opened because openAllure property is false");
        }


    }

}