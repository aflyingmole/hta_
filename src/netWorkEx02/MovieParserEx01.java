package netWorkEx02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MovieParserEx01 {

    public static StringBuilder readFile(String fileName) {
        BufferedReader br = null;
        StringBuilder sbResult = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                sbResult.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
        return sbResult;
    }

    public static void main(String[] args) {
        StringBuilder sbResult = readFile("C:\\Users\\jhta\\Downloads\\hta_\\src\\netWorkEx02\\Movie.xml");

        Document doc = Jsoup.parse(sbResult.toString());
        Elements books = doc.select("dailyBoxOffice");

        for (Element book : books) {
            String name = book.selectFirst("movieNm").text();
            int money = Integer.parseInt(book.selectFirst("salesAmt").text());
            int audiCnt = Integer.parseInt(book.selectFirst("audiCnt").text());
            long salesAcc = Long.parseLong(book.selectFirst("salesAcc").text());
            long audiAcc = Long.parseLong(book.selectFirst("audiAcc").text());

            System.out.printf("%s / %,d 원 / %,d 명 / %,d 원 / %,d 명\n", name, money, audiCnt, salesAcc, audiAcc);
        }
    }
}
