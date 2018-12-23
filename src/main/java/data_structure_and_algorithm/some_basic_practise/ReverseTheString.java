package data_structure_and_algorithm.some_basic_practise;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-20 11:24
 * Description://TODO 不使用java类库的方法实现对字符串的反转
 */
public class ReverseTheString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("反转前的字符串为：" + str);
        System.out.println("逆序遍历方法输出为： " + reverse2(str));
        System.out.println("递归法输出为： " + reverse3(str));

    }

    //1.数组反转：先将字符串转换为字符数组，然后对数组进行反转，反转后再转换为字符串



    //2.逆序遍历
    public static String reverse2(String s){

        StringBuilder stringBuilder = new StringBuilder();

        char[] ch = s.toCharArray();
        for (int i = ch.length-1; i >= 0; i--){
            stringBuilder.append(ch[i]);
        }
        return stringBuilder.toString();

    }

    //3.递归法
    public static String reverse3(String s){

        if (s.length() <= 1){
            return s;
        }
        return reverse3(s.substring(1)) + s.charAt(0);
        //注意的是，substring的参数是beginIndex，从当前位置一直取至最终
        //递归方法会创建出大量的字符串对象，所以效率比较低

    }





}
