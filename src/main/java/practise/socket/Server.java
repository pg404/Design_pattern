package practise.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket
 * Author: Alan Ruan
 * Date: 2019-03-27  15:20
 * Description: //TODO
 */
public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("监听在端口号：8888");
            Socket socket = serverSocket.accept();

            System.out.println("有连接过来");

            //打开输入流
            InputStream inputStream = socket.getInputStream();
            int msg = inputStream.read();

            System.out.println(msg);

            //把输入流封装在DataInputStream
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //使用readUTF读取字符串
            String message = dataInputStream.readUTF();
            System.out.println(message);

            dataInputStream.close();

            inputStream.close();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
