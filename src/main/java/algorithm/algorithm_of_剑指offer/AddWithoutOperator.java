package algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-12-08 17:11
 * Description://TODO  47.写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：利用位运算
 */
public class AddWithoutOperator {

    public static void main(String[] args) {
        System.out.println(add(2,3));
        System.out.println(add(9,3));
        System.out.println(add(0,6));
        System.out.println(add(-1,2));
    }

    private static int add(int m, int n){
        while (n != 0){
            int temp = m ^ n;
            n = (m & n) << 1;
            m = temp;
        }
        return m;
    }

}
