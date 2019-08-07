package practise.socket.GUI;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket.GUI
 * Author: Alan Ruan
 * Date: 2019-03-29  15:18
 * Description: //TODO
 */
public class ReceiveThread extends Thread {

    private Socket socket;
    private JTextArea dialog;
    private String sender;

    public ReceiveThread(Socket s, JTextArea j, String string){
        this.sender = string;
        this.dialog = j;
        this.socket = s;
    }

    @Override
    public void run(){

        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            while (true){
                String message = inputStream.readUTF();
                dialog.append(sender);
                dialog.append(": ");
                dialog.append(message);
                dialog.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
