package main.java.data_structure_and_algorithm.algorithm_of_剑指offer;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.algorithm_of_剑指offer
 * Author:Alan Ruan
 * Date:2018-11-25 15:38
 * Description://TODO .输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *a&(a-1)的结果会将a最右边的1变为0，直到a = 0
 *
 *
 */
public class NumOfOne {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countOne(n));


    }

    public static int countOne(int i ){
        int count = 0;
        while (i != 0){
            count++;
            i = i & (i-1);
        }

        return count;
    }

}
