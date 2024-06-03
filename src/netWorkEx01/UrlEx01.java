package netWorkEx01;

import java.util.Arrays;
import java.util.StringTokenizer;

public class UrlEx01 {
    public static void main(String[] args) {


    String url = "https://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1";

    // 프로토콜 : http
    // 호스트명 : www.codechobo.com
    // 포트명 : 80

    // String 클래스로 분리

        StringTokenizer st = new StringTokenizer(url, ":/");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
