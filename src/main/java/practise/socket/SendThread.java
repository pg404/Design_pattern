package practise.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket
 * Author: Alan Ruan
 * Date: 2019-03-29  14:56
 * Description: //TODO  SendThread 发送消息线程
 */
public class SendThread extends Thread{

    private Socket socket;

    public SendThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

        try {
            OutputStream  outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            while (true){
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                dataOutputStream.writeUTF(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
