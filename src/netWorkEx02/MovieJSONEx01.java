package netWorkEx02;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MovieJSONEx01 {

    public static StringBuilder readFile(String fileName) {
        BufferedReader br = null;
        StringBuilder sbResult = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\jhta\\Downloads\\hta_\\src\\netWorkEx02\\movie.json"));

            String line;
            while ((line = br.readLine()) != null) {
                sbResult.append(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) try {
                br.close();
            } catch (IOException e) {
            }
        }
        return sbResult;
    }
    public static void main(String[] args) {
        StringBuilder sbResult = readFile("C:\\Users\\jhta\\Downloads\\hta_\\src\\netWorkEx02\\movie.json");
        //System.out.println(sbResult.toString());

        JSONParser parser = new JSONParser();

        try {
            JSONArray arr = (JSONArray) parser.parse(sbResult.toString());

            for (int i = 0; i < arr.size(); i++) {
                JSONObject obj = (JSONObject) arr.get(i);

                String result = String.format("%s / %s / %s ", (String)obj.get("movieNm"),(String)obj.get("openDt"),(String)obj.get("audiAcc"));

                System.out.println(result);
            }

        } catch (ParseException e) {
            System.out.println("[에러]" + e.getMessage());
        }
    }
}
