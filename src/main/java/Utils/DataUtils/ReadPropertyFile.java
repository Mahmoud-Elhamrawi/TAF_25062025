package Utils.DataUtils;

import Utils.Logs.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertyFile {


    //load property file
    static String propertyFilePath = "src/main/resources/";

    public static Properties loadPropertyFile() {
        try {
            Properties properties = new Properties();
            Collection<File> fileCollection;
            fileCollection = FileUtils.listFiles(new File(propertyFilePath), new String[]{"properties"}, true);
            fileCollection.forEach(file -> {
                try {
                    properties.load(Files.newInputStream(file.toPath()));
                    properties.putAll(System.getProperties());
                    System.getProperties().putAll(properties);
                } catch (Exception e) {
                    LogClass.error("fail to load property file " + e.getMessage());
                }
            });
            return properties;
        } catch (Exception e) {
            LogClass.error("fail to load property file " + e.getMessage());
            return null;
        }


    }


    public static String getPropertyKey(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogClass.error("fail to get property key " + e.getMessage());
            return null;
        }

    }


}
