package practise.io;

import java.io.File;

/**
 * Project: SomethingAboutJava
 * Package: practise.io
 * Author: Alan Ruan
 * Date: 2019-03-19  22:19
 * Description: //TODO  遍历C盘windows文件夹下文件【不包含子文件夹】，找出最大文件与最小文件
 */
public class TestFileInCDisk {

    public static void main(String[] args) {

        File f = new File("c:\\windows");
        File[] fs = f.listFiles();

        if (null == fs){
            return;
        }
        long minSize = Integer.MAX_VALUE;
        long maxSize = 0;

        File minFile = null;
        File maxFile = null;

        for (File file : fs){
            if (file.isDirectory()){
                continue;
            }

            if (file.length() > maxSize){
                maxSize = file.length();
                maxFile = file;
            }

            if (file.length() != 0 && file.length() < minSize){
                minSize = file.length();
                minFile = file;
            }
        }

        System.out.printf("最大的文件是%s, 其大小是%,d字节%n", maxFile.getAbsoluteFile(), maxFile.length());
        System.out.printf("最小的文件是%s, 其大小是%,d字节%n", minFile.getAbsoluteFile(), minFile.length());


    }

}
