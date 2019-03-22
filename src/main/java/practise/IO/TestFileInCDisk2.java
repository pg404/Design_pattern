package practise.IO;

import java.io.File;

/**
 * Project: SomethingAboutJava
 * Package: practise.IO
 * Author: Alan Ruan
 * Date: 2019-03-19  22:30
 * Description: //TODO 遍历C盘下Windows文件夹下文件【包含子文件夹】，找出最大文件与最小文件
 */
public class TestFileInCDisk2 {

    static long minSize = Integer.MAX_VALUE;
    static long maxSize = 0;
    static File maxFile = null;
    static File minFile = null;

    //使用递归来遍历文件夹
    public static void  listFiles(File file){
        if (file.isFile()){
            if (file.length() > maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if (file.length() != 0 && file.length() < minSize){
                minSize  = file.length();
                minFile = file;
            }
            return;
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (null != files){
                for (File f : files){
                    listFiles(f);
                }
            }
        }

    }

    public static void main(String[] args) {

        File file = new File("c:\\windows");
        listFiles(file);

        System.out.printf("最大的文件是%s, 其大小是%,d字节%n", maxFile.getAbsoluteFile(), maxFile.length());
        System.out.printf("最小的文件是%s, 其大小是%,d字节%n", minFile.getAbsoluteFile(), minFile.length());

    }

}
