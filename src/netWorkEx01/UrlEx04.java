package netWorkEx01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlEx04 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://m.daum.net");
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }
}
