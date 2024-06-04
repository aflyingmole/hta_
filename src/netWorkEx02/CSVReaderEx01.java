package netWorkEx02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderEx01 {
    public static void main(String[] args) {
        BufferedReader br = null;
        StringBuilder sbResult = new StringBuilder();

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\jhta\\Downloads\\hta_\\src\\netWorkEx02\\Data.csv"));

            String line;
            while ((line = br.readLine()) != null) {
                sbResult.append(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if( br != null ) try { br.close(); } catch( IOException e ) {}
        }

        //System.out.println(sbReault.toString());

        String[] datas = sbResult.toString().split("\n");
        for (String data : datas) {
            //System.out.println(data);
            String[] lines = data.split(",");

            String line = String.format("%s / %s / %s / %s", lines[0], lines[1], lines[2], lines[3]);
            System.out.println(line);
        }
    }
}
