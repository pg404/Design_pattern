package practise.socket.GUI;

import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project: SomethingAboutJava
 * Package: practise.socket.GUI
 * Author: Alan Ruan
 * Date: 2019-03-29  15:36
 * Description: //TODO
 */
public class GUIServer {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(8887);
        System.out.println("Waiting for client connection ...");
        Socket incoming = serverSocket.accept();

        System.out.println("Client connected");
        System.out.println(incoming.toString());

        ServerFrame frame  = new ServerFrame(incoming);
        frame.setTitle("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new ReceiveThread(incoming, frame.dialog, "Client").start();

    }




}

class ServerFrame extends JFrame{

    public static final int DEFAULT_ROWS = 30;
    public static final int DEFAULT_COLUMNS = (int) (DEFAULT_ROWS * 0.6);
    JTextArea dialog = new JTextArea(DEFAULT_ROWS, DEFAULT_COLUMNS);
    JTextField message = new JTextField(20);

    JButton send = new JButton("SEND");
    private Socket socket;

    public ServerFrame(Socket s){
        this.socket = s;
        setName("Client");

        add(new JScrollPane(dialog), BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(message);
        panel.add(send);
        add(panel, BorderLayout.SOUTH);

        send.addActionListener(e -> {
            SendMethod.send(s, message, dialog, "Server");
        });

        pack();

    }

}
