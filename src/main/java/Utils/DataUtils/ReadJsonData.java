package Utils.DataUtils;

import Utils.Logs.LogClass;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonData {


    // create constructor to read data

    static String fileName;
    static String jsonFilePath = "src/test/resources/";
    static String jsonReader;


    public ReadJsonData(String fileName) {
        ReadJsonData.fileName = fileName;

        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath + fileName + ".json"));
            jsonReader = jsonObject.toJSONString();

        } catch (Exception e) {
            LogClass.error("fail to read json file" + e.getMessage());
        }
    }


    public static String getJsonKey(String jsonPath) {
        String jsonData;
        try {
            jsonData = JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            LogClass.error("fail to get json key " + e.getMessage());
            return null;
        }
        return jsonData;
    }


}
