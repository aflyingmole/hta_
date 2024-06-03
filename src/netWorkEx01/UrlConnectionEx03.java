package netWorkEx01;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionEx03 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;


        try {
            URLConnection conn = new URL("https://item.kakaocdn.net/do/ecd6f9ebd003816543861aa11ef3caddb3a18fdf58bc66ec3f4b6084b7d0b570").openConnection();

            bis = new BufferedInputStream(conn.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream("./image.jpg"));

            int data = 0;

            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            System.out.println("이미지 전송 완료");
        } catch (IOException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (bos != null) try {
                bos.close();
            } catch (IOException e) {
            }
            if (bis != null) try {
                bis.close();

            } catch (IOException e) {
            }
        }
    }
}
