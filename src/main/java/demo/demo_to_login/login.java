package main.java.demo.demo_to_login;

import javax.swing.*;
import java.awt.*;

/**
 * Project:Exercise
 * Package:main.java.demo.demo_to_login
 * Author:Alan Ruan
 * Date:2018-12-07 19:22
 * Description://TODO
 */

public class login {
    public static void main(String[] args)
    {
        login login=new login();
        login.init();
    }
    public void init()
    {
        JFrame frame=new JFrame();
        frame.setSize(400,350);
        frame.setTitle("QQ登录");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);

        //设置布局
        java.awt.FlowLayout f1=new java.awt.FlowLayout(FlowLayout.CENTER);
        frame.setLayout(f1);

        //其他元素组件
        javax.swing.ImageIcon image=new ImageIcon("D:/IdeaProjects/Exercise/src/main/java/demo/demo_to_login/qq.png");
        JLabel labelImage = new JLabel(image);
        frame.add(labelImage);

        //the accout number
        JLabel labelName1 = new JLabel("账号：");
        frame.add(labelName1);
        JTextField textName = new JTextField();
        Dimension dim1 = new Dimension(325,25);
        textName.setPreferredSize(dim1);
        frame.add(textName);

        //the password
        JLabel labelName2 = new JLabel("密码：");
        frame.add(labelName2);
        JPasswordField password=new JPasswordField();
        Dimension dim2 = new Dimension(325,25);
        password.setPreferredSize(dim2);
        frame.add(password);

        javax.swing.JLabel blank1 = new javax.swing.JLabel("                               ");
        frame.add(blank1);

        JCheckBox cb2 = new JCheckBox("记住密码");
        frame.add(cb2);

        javax.swing.JLabel blank2 = new javax.swing.JLabel("             ");
        frame.add(blank2);


        JCheckBox cb1 = new JCheckBox("自动登录");
        frame.add(cb1);

        javax.swing.JLabel blank3 = new javax.swing.JLabel("                ");
        frame.add(blank3);

        javax.swing.JLabel blank4 = new javax.swing.JLabel("                             ");
        frame.add(blank4);

        //String s = "登录";
        javax.swing.JButton button = new javax.swing.JButton("登录");
        java.awt.Dimension dim4 = new java.awt.Dimension(200,20);
        button.setPreferredSize(dim4);
        frame.add(button);

        frame.setVisible(true);

    }
}

