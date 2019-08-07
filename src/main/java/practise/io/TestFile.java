package practise.io;

import java.io.File;

/**
 * Project: SomethingAboutJava
 * Package: practise.io
 * Author: Alan Ruan
 * Date: 2019-03-19  22:08
 * Description: //TODO
 */
public class TestFile {

    public static void main(String[] args) {

        File f1 = new File("d:/AlanFolder");
        System.out.println("f1的绝对路径： " + f1.getAbsolutePath());
        System.out.println(f1.exists());

        File f2 = new File("alan.exe");
        System.out.println("f2的绝对路径： " + f2.getAbsolutePath());
        System.out.println(f2.exists());

        File f3 = new File(f1, "alan2.exe");
        System.out.println("f3的绝对路径： " + f3.getAbsolutePath());
        System.out.println(f3.exists());

    }

}
