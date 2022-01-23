package utils;

import com.google.gson.Gson;
import models.DifficultUser;
import models.User;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

    public static User parseUser(String file) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader( Parser.parse("jsonPath") + file)) {
            return gson.fromJson(reader, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DifficultUser parseDifficultUser(String file) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(Parser.parse("jsonPath") + file)) {
            return gson.fromJson(reader, DifficultUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String parse(String key) {
        JSONParser parser = new JSONParser();
        String value = null;
        try (FileReader reader = new FileReader("./src/test/resources/testData.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            value = (String) jsonObject.get(key);
        } catch (IOException | ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return value;
    }
}