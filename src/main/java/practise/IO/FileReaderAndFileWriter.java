package practise.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Project: SomethingAboutJava
 * Package: practise.IO
 * Author: Alan Ruan
 * Date: 2019-03-20  10:17
 * Description: //TODO
 */
public class FileReaderAndFileWriter {

    public static void main(String[] args) {

        File f = new File("d:/alan2.txt");

        try(FileReader fileReader = new FileReader(f)){
            char[] all = new char[(int) f.length()];
            fileReader.read(all);

            for (char c : all){
                System.out.println(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileWriter fileWriter = new FileWriter(f)) {
            String data = "afhalsdhfla1e24124";
            char[] chars = data.toCharArray();
            fileWriter.write(chars);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
