package practise.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Project: SomethingAboutJava
 * Package: practise.io
 * Author: Alan Ruan
 * Date: 2019-03-20  09:47
 * Description: //TODO
 */
public class TestStream {

    public static void main(String[] args) {
        try {
            File f = new File("d:/alanteststream.txt");
            FileInputStream fileInputStream = new FileInputStream(f);

            byte[] all = new byte[(int) f.length()];
            fileInputStream.read(all);

            for (byte b : all){
                System.out.println(b);
            }

            fileInputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
