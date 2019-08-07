package practise.io;

import java.io.*;

/**
 * Project: SomethingAboutJava
 * Package: practise.io
 * Author: Alan Ruan
 * Date: 2019-03-20  16:15
 * Description: //TODO
 */
public class DataInputStreamAndOutputStream {

    public static void main(String[] args) {

        write();
        read();

    }

    public static void read(){
        File file = new File("d:/alan4");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                )
        {
            boolean b = dataInputStream.readBoolean();
            int i = dataInputStream.readInt();
            String s = dataInputStream.readUTF();

            System.out.println("读取到布尔值:" + b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+s);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void write(){
        File file = new File("d:/alan4");
        try (
                FileOutputStream fos  = new FileOutputStream(file);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(30420);
            dos.writeUTF("1312hflasdhflahldf fahl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
