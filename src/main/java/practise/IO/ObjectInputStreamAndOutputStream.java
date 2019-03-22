package practise.IO;

import java.io.*;

/**
 * Project: SomethingAboutJava
 * Package: practise.IO
 * Author: Alan Ruan
 * Date: 2019-03-20  16:23
 * Description: //TODO 创建一个Hero对象，设置其名称为garen。
 * 把该对象序列化到一个文件garen.lol。
 * 然后再通过序列化把该文件转换为一个Hero对象
 */
public class ObjectInputStreamAndOutputStream {

    public static void main(String[] args) {

        //创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
        Hero h = new Hero();
        h.name = "garen";
        h.hp= 666;

        //准备一个文件用于保存该对象
        File f =new File("d:/garen.lol");

        try(
                //创建对象输出流
                FileOutputStream fileOutputStream = new FileOutputStream(f);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                //创建对象输入流
                FileInputStream fileInputStream = new FileInputStream(f);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ){
                    objectOutputStream.writeObject(h);
                    Hero h2 = (Hero) objectInputStream.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }



}
