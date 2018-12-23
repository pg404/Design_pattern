package data_structure_and_algorithm.leetcode;

import java.util.Scanner;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm.leetcode
 * Author:Alan Ruan
 * Date:2018-12-13 15:48
 * Description://TODO  Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 *
 * example
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 */
public class IntegerToRoman_12 {

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(intToRoman(num));


    }

    private static String intToRoman(int num){

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

}
