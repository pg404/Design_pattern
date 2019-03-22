package practise.IO;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Project: SomethingAboutJava
 * Package: practise.IO
 * Author: Alan Ruan
 * Date: 2019-03-20  15:39
 * Description: //TODO  以字符 中 为例，查看其在不同编码方式下的值是多少
 */
public class ShowDifferentCode {

    public static void main(String[] args) {
        String s = "国";
        showCode(s);

        //用FileInputStream 字节流正确读取中文
        System.out.println("用FileInputStream 字节流正确读取中文");
        File f = new File("d:/alan2.txt");
        try (FileInputStream fis = new FileInputStream(f);) {
            byte[] all = new byte[(int) f.length()];
            fis.read(all);

            //文件中读出来的数据是
            System.out.println("文件中读出来的数据是：");
            for (byte b : all)
            {
                int i = b&0x000000ff;  //只取16进制的后两位
                System.out.println(Integer.toHexString(i));
            }
            System.out.println("把这个数字，放在GBK的棋盘上去：");
            String str = new String(all,"GBK");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //用FileReader 字符流正确读取中文
        System.out.println("用FileReader 字符流正确读取中文");
        File f2 = new File("d:/alan3.txt");
        System.out.println("默认编码方式:"+ Charset.defaultCharset());

        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
        try (FileReader fr = new FileReader(f2)) {
            char[] cs = new char[(int) f2.length()];
            fr.read(cs);
            System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
            System.out.println(new String(cs));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f2),Charset.forName("UTF-8"))) {
            char[] cs = new char[(int) f2.length()];
            isr.read(cs);
            System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
            System.out.println(new String(cs));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void showCode(String str, String encode){
        try {
            System.out.printf("字符：\"%s\"在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs){
                int i = b & 0xff;
                System.out.printf(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }

    }

}
