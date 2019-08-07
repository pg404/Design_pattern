package practise.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket
 * Author: Alan Ruan
 * Date: 2019-03-26  15:16
 * Description: //TODO
 */
public class IPConfig {

    public static void main(String[] args) {

        try {
            InetAddress host = InetAddress.getLocalHost();
            String ip = host.getHostAddress();
            System.out.println("本机ip地址：" + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
