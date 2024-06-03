package jSoupEx01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupEx01 {
    public static void main(String[] args) {

        String strHtml = "<html>"
                + "<head>"
                + "<title>Hello JSoup</title>"
                + "</head>"
                + "<body>"
                + "<p>hello JSoup document 1<p>"
                + "<p>hello JSoup document 1<p>"
                + "</body>"
                + "</html>";

        // Document
        // DOM
        Document doc = Jsoup.parse(strHtml);
        System.out.println(doc);

        // 문서에 대한 정보
        System.out.println(doc.head());
        System.out.println(doc.body());

        System.out.println(doc.title());
        System.out.println(doc.charset());

        // html
        // getElementById / getElementsByTag ...

        Elements titles = doc.getElementsByTag("title");
        System.out.println(titles);
        System.out.println(titles.text());

        Elements pTags = doc.getElementsByTag("p");
        System.out.println(pTags);
        System.out.println(pTags.size());


        for (int i = 0; i < pTags.size(); i++) {
            Element pTag = pTags.get(i);

            System.out.println(pTag);
            System.out.println(pTag.tagName());
            System.out.println(pTag.text());
        }

    }
}
