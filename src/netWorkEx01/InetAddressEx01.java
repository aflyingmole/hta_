package netWorkEx01;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx01 {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = Inet6Address.getByName("www.daum.net");
            System.out.println("호스트 주소: " + inetAddress1.getHostAddress());

            InetAddress[] inetAddresses1 = InetAddress.getAllByName("www.naver.com");
            for (InetAddress inetAddress : inetAddresses1) {
                System.out.println(inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("호스트를 찾을 수 없습니다: " + e.getMessage());
        }
    }
}
