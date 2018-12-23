package java_basic;

/**
 * Project:Exercise
 * Package:main.java.java_basic
 * Author:Alan Ruan
 * Date:2018-11-07 16:26
 * Description://TODO  移位运算符>>, <<, >>>的测试
 */
public class YiWeiOperator {

    public static void main(String[] args){
        int num = 10;
        printBinary(num);

        num = num >> 1;
        printBinary(num);

        num = num << 1;
        printBinary(num);

        num = num >>> 1;
        printBinary(num);

    }

    public static void printBinary(int num){
        System.out.println(Integer.toBinaryString(num));
    }

}
