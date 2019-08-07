package practise.io;

import java.io.*;

/**
 * Project: SomethingAboutJava
 * Package: practise.io
 * Author: Alan Ruan
 * Date: 2019-03-20  16:03
 * Description: //TODO 使用缓存流读写数据
 */
public class BufferReaderAndWriter {

    public static void main(String[] args) {

        File f = new File("d:/alan2.txt");

        try (
                FileReader fileReader = new FileReader(f);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                )
        {
            while (true){
                String line = bufferedReader.readLine();
                if (null == line){
                    break;
                }
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        //向文件写入三行数据
        try(
                FileWriter fileWriter = new FileWriter(f);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                )
        {
            printWriter.println("this is about buffer");
            printWriter.println("I used bufferReader and printWriter");

            //有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush
            printWriter.flush();

            printWriter.println("what about bufferedWriter?");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
