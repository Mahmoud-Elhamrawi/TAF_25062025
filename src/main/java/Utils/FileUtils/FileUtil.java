package Utils.FileUtils;

import Utils.Logs.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtil {


    public static String logsPath = "test-outputs/Logs/";

    // get last file
    public static File getLastFile(String directoryPath) {

        File dir = new File(directoryPath);
        if (!dir.exists()) {
            LogClass.error("Directory does not exist");
        }
        File[] files = dir.listFiles();
        assert files != null;
        if (files.length == 0) {
            LogClass.error("Directory is empty");
        }

        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];

    }


    //clean directory
    public static void cleanDirectory(File directoryPath) {
        try {
            FileUtils.deleteQuietly(directoryPath);
        } catch (Exception e) {
            LogClass.error("fail to clean directory " + e.getMessage());
        }
    }

}
