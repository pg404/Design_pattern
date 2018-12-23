package data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-08 17:23
 * Description://TODO 49.将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法
 * 的数值则返回0
 * 思路：若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false。
 */
public class StringToInt {

    public static void main(String[] args) {
        String s = "421704";
        System.out.println(s);
        System.out.println(strToInt(s));
    }

    private static int strToInt(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        int mark = 0;
        int number = 0;

        char[] chars = str.toCharArray();
        if (chars[0] == '-'){
            mark = 1;
        }
        for (int i = mark; i < chars.length; i++){
            if (chars[i] == '+'){
                continue;
            }
            if (chars[i] < 48 || chars[i] > 57){
                return 0;
            }
            number = number * 10 + chars[i] - 48;
        }

        return mark == 0 ?  number : -number;
    }

}
