package netWorkEx02;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx02 {
    public static void main(String[] args) {


        String strJson = "{ \"key1\":\"value1\", \"key2\":\"value2\" }";

        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(strJson);
            System.out.println(obj.toString());

            // Map 구조
            String key1 = (String) obj.get("key1");
            System.out.println(key1);

        } catch (ParseException e) {
            System.out.println("[에러]" + e.getMessage());
        }

    }
}
