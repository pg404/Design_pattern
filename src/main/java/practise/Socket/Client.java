package practise.Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Project: SomethingAboutJava
 * Package: practise.Socket
 * Author: Alan Ruan
 * Date: 2019-03-27  15:22
 * Description: //TODO
 */
public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println(socket);

            //打开输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(110);


            //把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(outputStream);
            //使用writeUTF发送字符串
            dos.writeUTF("Legendary!");


            //使用Scanner读取控制台的输入，并发送到服务端
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();

            dos.writeUTF(s);

            dos.close();

            outputStream.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
