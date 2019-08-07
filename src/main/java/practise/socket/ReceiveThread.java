package practise.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket
 * Author: Alan Ruan
 * Date: 2019-03-29  15:01
 * Description: //TODO RecieveThread 接受消息线程
 */
public class ReceiveThread extends Thread{

    private Socket socket;

    public ReceiveThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            while (true){
                String msg = dataInputStream.readUTF();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
