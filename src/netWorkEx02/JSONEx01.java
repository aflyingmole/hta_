package netWorkEx02;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx01 {
    public static void main(String[] args) {


        // json - simple 연습
        // validation 검사를 반드시 할 것
        //String strJson = "[ 1,2,3,4 ]";
        String strJson = "[ \"1\", \"2\", \"3\", \"4\" ]";


        JSONParser parser = new JSONParser();

        try {
            JSONArray arr = (JSONArray) parser.parse(strJson);
            System.out.println(arr);

            for (int i = 0; i < arr.size(); i++) {

                // 정수 => Long
                String data = (String) arr.get(i);
                System.out.println(data);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
