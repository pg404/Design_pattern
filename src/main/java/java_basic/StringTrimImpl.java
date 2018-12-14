package main.java.java_basic;

/**
 * Project:Exercise
 * Package:main.java.java_basic
 * Author:Alan Ruan
 * Date:2018-12-08 15:49
 * Description://TODO 测试String的trim方法
 */
public class StringTrimImpl {

    public static void main(String[] args) {
        String a = "  Hello World  ";
        String b = "Hello World";
        System.out.println(a.equals(b));

        a = a.trim();

        System.out.println(a.equals(b));
        System.out.println(a==b);
    }
}

