package practise.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project: SomethingAboutJava
 * Package: practise.io
 * Author: Alan Ruan
 * Date: 2019-03-20  09:53
 * Description: //TODO
 */
public class TestStream2 {

    public static void main(String[] args) {

        File f = new File("d:/alan2.txt");
        FileOutputStream fileOutputStream = null;
        try {

//            File f = new File("d:/alan2.txt");
            byte[] data = {88,89,90};

//            FileOutputStream fileOutputStream = new FileOutputStream(f);
            fileOutputStream = new FileOutputStream(f);

            fileOutputStream.write(data);

//            fileOutputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }finally {

            /*
            这是标准的关闭流的方式
            1. 首先把流的引用声明在try的外面，如果声明在try里面，其作用域无法抵达finally.
            2. 在finally关闭之前，要先判断该引用是否为空
            3. 关闭的时候，需要再一次进行try catch处理
            */

            if (null != fileOutputStream){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*
         使用try()的方式 顶 折 纠 问
         把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
         这种编写代码的方式叫做 try-with-resources， 这是从JDK7开始支持的技术
        */
        File f2 = new File("d:/alan/test/alantest.txt");
        try (FileOutputStream fileOutputStream1 = new FileOutputStream(f2)){
//            File f2 = new File("d:/alan/test/alantest.txt");
            //因为默认情况下，文件系统中不存在 d:\xyz\abc\def，所以输出会失败

            //首先获取文件所在的目录
            File dir = f2.getParentFile();
            //如果该目录不存在，则创建该目录
            if (!dir.exists()){
                dir.mkdirs();
                //              dir.mkdir(); //使用mkdir会抛出异常，因为该目录的父目录也不存在
                 //使用mkdirs则会把不存在的目录都创建好
            }

            byte[] bytes = {1,2,3,4,5};
//            fileOutputStream = new FileOutputStream(f2);
            fileOutputStream1.write(bytes);

//            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
