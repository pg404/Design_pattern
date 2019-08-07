package practise.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket
 * Author: Alan Ruan
 * Date: 2019-03-26  15:22
 * Description: //TODO
 */
public class PingViaJava {

    public static void main(String[] args) throws IOException {

        Process p = Runtime.getRuntime().exec("ping " + "192.168.78.1");
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null){
            if (line.length() != 0){
                stringBuilder.append(line + "\r\n");
            }
        }
        System.out.println("本次指令返回的消息是： ");
        System.out.println(stringBuilder.toString());

    }

}
