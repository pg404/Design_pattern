package practise.Socket.GUI;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.Socket.GUI
 * Author: Alan Ruan
 * Date: 2019-03-29  15:22
 * Description: //TODO
 */
public class GUIClient {

    public static void main(String[] args) throws Exception{

        Socket client = new Socket(InetAddress.getLocalHost(), 8887);
        System.out.println("Connected to Server");

        ClientFrame frame = new ClientFrame(client);

        frame.setTitle("Client");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        new ReceiveThread(client, frame.dialog, "Server").start();

    }



}
class ClientFrame extends JFrame{

    public static final int DEFAULT_ROWS  = 30;
    public static final int DEFAULT_COLUMNS = (int) (DEFAULT_ROWS * 0.6);

    JTextArea dialog = new JTextArea(DEFAULT_ROWS, DEFAULT_COLUMNS);
    JTextField message = new JTextField(20);

    JButton send = new JButton("SEND");

    private Socket socket;

    public ClientFrame(Socket socket){
        this.socket = socket;
        setName("Client");
        add(new JScrollPane(dialog), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(message);
        panel.add(send);

        add(panel, BorderLayout.SOUTH);
        send.addActionListener(e ->
                {SendMethod.send(socket, message, dialog, "Client");}
                );

        pack();

    }

}
