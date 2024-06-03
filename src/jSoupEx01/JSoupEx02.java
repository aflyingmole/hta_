package jSoupEx01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx02 {
    public static void main(String[] args) {
        String strHtml = "<html>" +
                "<head>" +
                "<title> Hello JSoup</title>" +
                "</head>" +
                "<body>" +
                "<p id = 'i1' class = 'c1'> hello doc 1 </p>" +
                "<p id = 'i2' class = 'c2'> hello doc 2 </p>" +
                "<p id = 'i3' class = 'c1'> hello doc 3 </p>" +
                "<p id = 'i4' class = 'c2'> hello doc 4 </p>" +
                "<p>hello jsoup doc1" +
                "<p>hello jsoup doc1" +
                "</body>" +
                "</html>";

        Document doc = Jsoup.parse(strHtml);

        Element pTag = doc.getElementById("i1");
        System.out.println(pTag);
        System.out.println(pTag.text());
        Elements pTags = doc.getElementsByClass("c1");
        System.out.println(pTags);

        for (Element tag : pTags) {
            System.out.println(tag.text());
        }
    }
}
