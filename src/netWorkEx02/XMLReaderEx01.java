package netWorkEx02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLReaderEx01 {

    public static StringBuilder readFile(String fileName) {
        BufferedReader br = null;
        StringBuilder sbResult = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\jhta\\Downloads\\hta_\\src\\netWorkEx02\\Data.xml"));

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
        StringBuilder sbResult = readFile("./Data.xml");
        System.out.println(sbResult.toString());
    }
}
