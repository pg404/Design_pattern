package practise.socket.GUI;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket.GUI
 * Author: Alan Ruan
 * Date: 2019-03-29  15:15
 * Description: //TODO
 */
public class SendMethod {

    public static void send(Socket socket, JTextField message, JTextArea dialog, String sender){

        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String s = message.getText();
            dialog.append(sender + ": " + s);
            dialog.append("\r\n");
            outputStream.writeUTF(s);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
