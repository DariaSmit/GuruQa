package jSonLession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSonSimpleParser {

    public Object parse(){

        Root root = new Root();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("test.json")) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            String name = (String)rootJsonObject.get("name");

            root.setName(name);

            return root;
        } catch (Exception e) {
            System.out.println("parsing error" + e.toString());
        }
        return root;
    }
}
