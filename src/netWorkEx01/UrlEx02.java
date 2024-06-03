package netWorkEx01;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlEx02 {
    public static void main(String[] args) {
        String strUrl = "https://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1";

        try {
            URL url = new URL(strUrl);

            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
