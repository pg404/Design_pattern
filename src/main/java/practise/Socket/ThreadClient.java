package practise.Socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.Socket
 * Author: Alan Ruan
 * Date: 2019-03-29  15:08
 * Description: //TODO
 */
public class ThreadClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
