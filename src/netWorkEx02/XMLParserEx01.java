package netWorkEx02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLParserEx01 {

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
        StringBuilder sbResult = readFile("C:\\Users\\jhta\\Downloads\\hta_\\src\\netWorkEx02\\Data.xml");

        Document doc = Jsoup.parse(sbResult.toString());
        Elements books = doc.select("book");

        for (Element book : books) {
            String title = book.selectFirst("name").text();
            String publisher = book.selectFirst("publisher").text();
            String author = book.selectFirst("author").text();
            String price = book.selectFirst("price").text();

            System.out.printf("%s / %s / %s / %s%n", title, publisher, author, price);
        }
    }
}
