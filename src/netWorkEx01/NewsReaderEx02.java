package netWorkEx01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsReaderEx02 {

    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            URL url = new URL("https://news.daum.net/");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            boolean flag = false;

            // 정규식 패턴: 한글 문자열
            Pattern pattern = Pattern.compile("[가-힣]+");

            while ((line = br.readLine()) != null) {
                if (line.contains("<ul class=\"list_newsissue\">")) {
                    flag = true;
                    continue;
                }

                if (line.contains("</ul>")) {
                    flag = false;
                }

                if (flag) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        System.out.println(matcher.group());
                    }
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }
}