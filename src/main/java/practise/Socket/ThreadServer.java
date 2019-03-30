package practise.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.Socket
 * Author: Alan Ruan
 * Date: 2019-03-29  15:04
 * Description: //TODO  Server一旦接受到连接，就启动收发两个线程
 */
public class ThreadServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("监听在端口号：8888");

            Socket socket = serverSocket.accept();

            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
