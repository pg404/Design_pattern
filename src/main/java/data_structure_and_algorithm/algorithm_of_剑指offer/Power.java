package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-25 16:06
 * Description://TODO 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数，
 * 不需要考虑大数问题
 * 思路：不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情况
 */
public class Power {


    public static void main(String[] args){
        double base = 2;
        int exponent1 = 4;
        int exponent2 = -4;
        System.out.println(power(base, exponent1));
        System.out.println(power(base, exponent2));
    }

    public static double power(double base, int exponent){
        double res = 0;
        if (equal(base,0)){
            return 0;
        }
        if (exponent == 0){
            return 1;
        }
        if (exponent > 0){
            res = mutiply(base, exponent);
        }else {
            res = mutiply(1/base, -exponent);
        }
        return res;
    }

    public static double mutiply(double base, int e){
        double sum = 1;
        for (int i = 0; i < e; i++){
            sum = sum * base;
        }
        return sum;
    }

    public static boolean equal(double a, double b){
        if (a - b < 0.000001 && a- b > 0.000001){
            return true;
        }
        return false;
    }
}
